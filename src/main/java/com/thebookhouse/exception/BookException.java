package com.thebookhouse.exception;

import java.util.List;

import org.springframework.validation.ObjectError;

public class BookException extends RuntimeException {

    /** Serial version UID */
    private static final long serialVersionUID = 7277495394219034900L;

    private List<ObjectError> errors;

    public BookException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookException(String message) {
        super(message);
    }

    public BookException(Throwable cause) {
        super(cause);
    }

    public BookException(List<ObjectError> errors) {
        this.errors = errors;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

}
