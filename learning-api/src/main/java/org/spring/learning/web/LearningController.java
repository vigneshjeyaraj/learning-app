package org.spring.learning.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LearningController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "HI";
    }
}
