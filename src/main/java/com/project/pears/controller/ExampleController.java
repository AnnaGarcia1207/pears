package com.project.pears.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "TESTING .. hello!";
    }
}
