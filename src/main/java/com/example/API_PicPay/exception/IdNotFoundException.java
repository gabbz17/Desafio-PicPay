package com.example.API_PicPay.exception;

public class IdNotFoundException extends  RuntimeException{
    public IdNotFoundException (String error){
        super(error);
    }
}
