package com.diogo.fashionBlog.exception;

public class WrongDetailsException extends RuntimeException{
    public WrongDetailsException(String message) {
        super(message);
    }
}
