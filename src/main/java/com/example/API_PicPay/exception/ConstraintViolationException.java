package com.example.API_PicPay.exception;

public class ConstraintViolationException extends RuntimeException{
    public ConstraintViolationException(String error){
        super(error);
    }
}
