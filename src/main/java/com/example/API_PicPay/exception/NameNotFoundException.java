package com.example.API_PicPay.exception;

public class NameNotFoundException extends RuntimeException{
    public NameNotFoundException(String error) {
        super(error);
    }
}
