package com.thebookhouse.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    HttpServletRequest request;

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleEntityException(EntityException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setTimeStamp(System.currentTimeMillis());
        response.setStatus(ex.getStatus().value());
        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());

        return new ResponseEntity<ErrorResponse>(response, ex.getStatus());
    }

    // Add method to handle other exception

}
