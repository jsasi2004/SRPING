package com.banglore.App.EXCEPTION_HANDLER;

public class EntityNotFound extends RuntimeException{
    public EntityNotFound(String message){
        super(message);
    }
}
