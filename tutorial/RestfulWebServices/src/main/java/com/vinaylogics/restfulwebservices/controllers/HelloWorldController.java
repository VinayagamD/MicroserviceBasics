package com.vinaylogics.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    // GET
    // URI - /hello-world
    //method - "Hello World"
    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }
}
