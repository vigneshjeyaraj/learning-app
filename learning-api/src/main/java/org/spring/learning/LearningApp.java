package org.spring.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:application-context.xml")
public class LearningApp {

    public static void main(String[] args) {
        SpringApplication.run(LearningApp.class, args);
    }
}
