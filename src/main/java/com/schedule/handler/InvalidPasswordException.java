package com.schedule.handler;

/**
 * @author : yong
 * @packageName : com.schedule.handler
 * @fileName : Exceptions
 * @date : 4/2/25
 * @description :
 */
public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String message){
        super(message);
    }
}
