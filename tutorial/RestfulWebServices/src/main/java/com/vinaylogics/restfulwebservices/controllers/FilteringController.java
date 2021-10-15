package com.vinaylogics.restfulwebservices.controllers;

import com.vinaylogics.restfulwebservices.models.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/filtering")
public class FilteringController {

    @GetMapping("/")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("Value1","Value2","Value3");
    }

    @GetMapping("/list")
    public List<SomeBean> retrieveSomeBeans(){
        return Arrays.asList(
                new SomeBean("Value1","Value2","Value3"),
                new SomeBean("Value12","Value22","Value32")
        );
    }
}
