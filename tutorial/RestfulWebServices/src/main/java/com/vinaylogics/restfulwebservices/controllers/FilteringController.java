package com.vinaylogics.restfulwebservices.controllers;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.vinaylogics.restfulwebservices.models.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/filtering")
public class FilteringController {

    @GetMapping("/")
    public MappingJacksonValue retrieveSomeBean(){
        var someBean = new SomeBean("Value1","Value2","Value3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/list")
    public MappingJacksonValue retrieveSomeBeans(){
        List<SomeBean> list = Arrays.asList(
                new SomeBean("Value1","Value2","Value3"),
                new SomeBean("Value12","Value22","Value32")
        );
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);
        return mapping;
    }
}
