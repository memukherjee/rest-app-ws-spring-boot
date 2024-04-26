package com.example.restappws.exceptions;

import com.example.restappws.ui.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Objects;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Date timestamp = new Date();
        String errorMessageDescription = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        ErrorMessage errorMessage = new ErrorMessage(timestamp, errorMessageDescription);
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorMessage> handleAllExceptions(Exception exception, WebRequest request) {
        Date currentTimestamp = new Date();
        String errorMessageDescription = exception.getLocalizedMessage();
        if(errorMessageDescription != null)
            errorMessageDescription = exception.toString();
        ErrorMessage errorMessage = new ErrorMessage(currentTimestamp, errorMessageDescription);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class, ArithmeticException.class })
    public ResponseEntity<ErrorMessage> handleSpecificExceptions(Exception exception, WebRequest request) {
        Date currentTimestamp = new Date();
        String errorMessageDescription = "Exception occurred: "+exception.getLocalizedMessage();
        ErrorMessage errorMessage = new ErrorMessage(currentTimestamp, errorMessageDescription);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = UserServiceException.class)
    public ResponseEntity<ErrorMessage> handleUserServiceExceptions(UserServiceException exception, WebRequest request) {
        Date currentTimestamp = new Date();
        String errorMessageDescription = "UserServiceException: "+exception.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(currentTimestamp, errorMessageDescription);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
