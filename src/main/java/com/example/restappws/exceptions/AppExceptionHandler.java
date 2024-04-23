package com.example.restappws.exceptions;

import com.example.restappws.ui.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorMessage> handleAllExceptions(Exception exception, WebRequest request) {
        Date currentTimestamp = new Date();
        String errorMessageDescription = exception.getLocalizedMessage();
        if(errorMessageDescription != null)
            errorMessageDescription = exception.toString();
        ErrorMessage errorMessage = new ErrorMessage(currentTimestamp, errorMessageDescription);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ErrorMessage> handleNullPointerExceptions(Exception exception, WebRequest request) {
        Date currentTimestamp = new Date();
        String errorMessageDescription = "Null pointer exception occurred";
        ErrorMessage errorMessage = new ErrorMessage(currentTimestamp, errorMessageDescription);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
