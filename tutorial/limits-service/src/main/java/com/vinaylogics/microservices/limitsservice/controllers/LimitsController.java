package com.vinaylogics.microservices.limitsservice.controllers;

import com.vinaylogics.microservices.limitsservice.beans.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limits")
public class LimitsController {

    @GetMapping("/")
    public Limits retrieveLimits(){
        return new Limits(1,1000);
    }
}
