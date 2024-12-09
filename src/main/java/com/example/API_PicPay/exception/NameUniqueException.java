package com.example.API_PicPay.exception;

public class NameUniqueException extends RuntimeException{
    public NameUniqueException(String error){
        super(error);
    }
}
