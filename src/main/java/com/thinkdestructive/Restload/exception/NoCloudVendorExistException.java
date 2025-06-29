package com.thinkdestructive.Restload.exception;

public class NoCloudVendorExistException extends RuntimeException{
    public NoCloudVendorExistException(String message){
         super(message);
    }
    public NoCloudVendorExistException(String message, Throwable cause){
        super(message, cause);
    }
}
