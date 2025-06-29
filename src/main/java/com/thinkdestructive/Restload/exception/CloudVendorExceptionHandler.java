package com.thinkdestructive.Restload.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CloudVendorExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotAcceptableStatusException.class)
    public ResponseEntity<Object> handleNotAcceptableStatusException(NotAcceptableStatusException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("error", "Not Acceptable");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.NOT_ACCEPTABLE.value());

        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = {CloudVendorNotFoundException.class})
    public ResponseEntity<Object> CloudVendorNotFoundException(CloudVendorNotFoundException cloudVendorNotFoundException){
        CloudVendorException cloudVendorException=new CloudVendorException(
                cloudVendorNotFoundException.getMessage(),
                cloudVendorNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(cloudVendorException,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {NoCloudVendorExistException.class})
    public ResponseEntity<Object> NoCloudVendorExistException(NoCloudVendorExistException noCloudVendorExistException){
        CloudVendorException cloudVendorException  = new CloudVendorException(
                noCloudVendorExistException.getMessage(),
                noCloudVendorExistException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(cloudVendorException,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex){
        Map<String,Object>error= new HashMap<>();
        error.put("Error", "Method not Allowed");
        error.put("Message",ex.getMessage());
        error.put("status", HttpStatus.METHOD_NOT_ALLOWED.value());
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
