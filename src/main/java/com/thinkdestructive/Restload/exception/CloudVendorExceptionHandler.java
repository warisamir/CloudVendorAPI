package com.thinkdestructive.Restload.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionHandler {
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
}
