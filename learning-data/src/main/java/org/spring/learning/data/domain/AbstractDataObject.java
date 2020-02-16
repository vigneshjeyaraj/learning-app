package org.spring.learning.data.domain;

import java.io.Serializable;
import java.util.*;

public abstract class AbstractDataObject implements Serializable {

    protected abstract Map<String, Object> getProperties();

    @Override
    public boolean equals(final Object obj) {
        //Compare Reference
        if (this == obj) {
            return true;
        }
        //Checking the Instance type.
        if (obj == null || !(obj instanceof AbstractDataObject)) {
            return false;
        }
        //Checking the properties and validating
        AbstractDataObject dataObject = (AbstractDataObject) obj;
        return getProperties().keySet()
                .stream()
                .map(key -> validateValuesAreEqual(dataObject, key))
                .reduce(true, (a, b) -> a && b);
    }

    @Override
    public int hashCode() {
        final SortedSet<String> keys = new TreeSet<>(getProperties().keySet());
        return keys.stream()
                .map(key -> Objects.hash(getProperties().get(key)))
                .reduce(0, (a, b) -> Objects.hash(a, b));
    }

    private boolean validateValuesAreEqual(final AbstractDataObject dataObject, final String key) {
        boolean isValuesEqual = false;
        if (getProperties().get(key) != null && dataObject.getProperties().get(key) != null) {
            //Validating it for Collection Type.
            if (getProperties().get(key) instanceof Collection) {
                isValuesEqual = ((Collection<?>) dataObject.getProperties().get(key))
                        .containsAll((Collection<?>) getProperties().get(key));
            } else if (getProperties().get(key) instanceof byte[]) {
                isValuesEqual = Arrays.equals((byte[]) dataObject.getProperties().get(key),
                        (byte[]) getProperties().get(key));
            } else {
                isValuesEqual = Objects.equals(dataObject.getProperties().get(key),
                        getProperties().get(key));
            }
        }
        return isValuesEqual;
    }
}
