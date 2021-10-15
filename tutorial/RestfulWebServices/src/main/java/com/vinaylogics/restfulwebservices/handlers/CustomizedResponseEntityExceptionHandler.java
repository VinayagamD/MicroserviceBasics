package com.vinaylogics.restfulwebservices.handlers;

import com.vinaylogics.restfulwebservices.exceptions.ExceptionResponse;
import com.vinaylogics.restfulwebservices.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Controller
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) throws Exception {
      ExceptionResponse exceptionResponse  = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
       return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
      ExceptionResponse exceptionResponse  = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
       return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
