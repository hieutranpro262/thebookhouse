package com.thebookhouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException(BookException ex) {
        BookErrorResponse response = new BookErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<BookErrorResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException(Exception ex) {
        BookErrorResponse response = new BookErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage("Error occur!");
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<BookErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }

/*    @ExceptionHandler
    public ResponseEntity<List<BookErrorResponse>> validateBookDetails(List<ObjectError> errors) {
        List<BookErrorResponse> responses = new ArrayList<>();
        for (ObjectError error : errors) {
            BookErrorResponse response = new BookErrorResponse();
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(error.getDefaultMessage());
            response.setTimeStamp(System.currentTimeMillis());
            responses.add(response);
        }

        return new ResponseEntity<List<BookErrorResponse>>(responses, HttpStatus.BAD_REQUEST);
    }*/

}
