package com.vinaylogics.restfulwebservices.controllers;

import com.vinaylogics.restfulwebservices.models.Name;
import com.vinaylogics.restfulwebservices.models.PersonV1;
import com.vinaylogics.restfulwebservices.models.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Vinay Ganesh");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Vinay", "Ganesh"));
    }
}
