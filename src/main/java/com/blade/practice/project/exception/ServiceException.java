package com.blade.practice.project.exception;

/**
 * TODO:
 *
 * @author blade
 * 2021/5/29 15:02
 */
public class ServiceException extends RuntimeException{
    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }
}
