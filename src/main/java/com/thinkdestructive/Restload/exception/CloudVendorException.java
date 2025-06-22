package com.thinkdestructive.Restload.exception;


import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class CloudVendorException {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

}
