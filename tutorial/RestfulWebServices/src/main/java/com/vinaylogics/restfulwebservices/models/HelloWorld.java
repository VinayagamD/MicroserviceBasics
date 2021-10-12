package com.vinaylogics.restfulwebservices.models;

public record HelloWorld(String message) {

    @Override
    public String toString() {
        return String.format("HelloWorld [message=%s]", message);
    }
}
