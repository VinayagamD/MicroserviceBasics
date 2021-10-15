package com.vinaylogics.restfulwebservices.controllers;

import com.vinaylogics.restfulwebservices.models.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

// Controller
@RestController
@RequestMapping()
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

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

    @GetMapping("/hello-world-internalized")
    public String helloWorldInternationalized(
            //@RequestHeader(name = "Accept-Language",required = false) Locale locale
    ){
        // return "Hello World";
        // en = Hello World
        // nl = Hallo Wereld
        // fr = Bonjour le monde
        return messageSource.getMessage("good.morning.message",null, "Default Message" ,
                //locale
                LocaleContextHolder.getLocale()
        );
    }
}
