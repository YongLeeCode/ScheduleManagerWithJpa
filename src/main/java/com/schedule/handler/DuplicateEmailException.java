package com.schedule.handler;

/**
 * @author : yong
 * @packageName : com.schedule.handler
 * @fileName : DuplicateEmailException
 * @date : 4/2/25
 * @description :
 */
public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String message) {
        super(message);
    }
}
