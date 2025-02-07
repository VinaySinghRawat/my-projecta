package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.Exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
