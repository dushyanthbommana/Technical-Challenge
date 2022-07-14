package com.demo.nace.exception;

import org.hibernate.QueryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.crypto.Data;

/**
 * This class catches all the exceptions
 */
@ControllerAdvice
public class NaceException {
    /**
     * This method catches queryException
     * @param exception
     * @return Error entity
     */
    @ExceptionHandler(value = QueryException.class)
    public ResponseEntity<Object> exception(QueryException exception) {
        Error error = new Error();
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method catches custom DataBaseException
     * @param exception
     * @return Error entity
     */
    @ExceptionHandler(value = DataBaseException.class)
    public ResponseEntity<Object> dataBaseException(DataBaseException exception) {
        Error error = new Error();
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
