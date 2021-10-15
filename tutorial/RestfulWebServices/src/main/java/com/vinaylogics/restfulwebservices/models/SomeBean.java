package com.vinaylogics.restfulwebservices.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"field1", "field2"})
public record SomeBean(String field1, String field2, /*@JsonIgnore*/ String field3) {
}
