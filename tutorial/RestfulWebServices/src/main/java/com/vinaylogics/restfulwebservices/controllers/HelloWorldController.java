package com.vinaylogics.restfulwebservices.controllers;

import com.vinaylogics.restfulwebservices.models.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
@RequestMapping()
public class HelloWorldController {

    // GET
    // URI - /hello-world
    //method - "Hello World"
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorld helloWorldBean(){
        return new HelloWorld("Hello World");
    }

    ///hello-world/path-variable/vinay
    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorld helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorld(String.format("Hello World, %s", name));
    }
}
