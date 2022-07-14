package com.demo.nace.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * This is custom exception class
 */
@Getter
@Setter
public class DataBaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    String message;
    public DataBaseException(String message){
        this.message = message;
    }
}
