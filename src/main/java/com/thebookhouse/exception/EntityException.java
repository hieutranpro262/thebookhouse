package com.thebookhouse.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

@SuppressWarnings("serial")
public class EntityException extends RuntimeException {

    private List<ObjectError> errors;

    private HttpStatus status;

    public EntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityException(String message) {
        super(message);
    }

    public EntityException(Throwable cause) {
        super(cause);
    }

    public EntityException(List<ObjectError> errors) {
        this.errors = errors;
    }

    public EntityException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
