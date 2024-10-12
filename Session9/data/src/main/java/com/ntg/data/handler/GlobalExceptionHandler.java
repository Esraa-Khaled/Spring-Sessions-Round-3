package com.ntg.data.handler;


import com.ntg.data.exceptions.PreventSaveException;
import com.ntg.data.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> RecordNotFoundExceptionHandler(RecordNotFoundException ex) {
        return new ResponseEntity<>(ex.getErrorMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PreventSaveException.class)
    public ResponseEntity<?> PreventSaveExceptionHandler(PreventSaveException ex) {
        return new ResponseEntity<>(
                new Error(ex.getErrorCode(), ex.getErrorMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> GeneralExceptionHandler(Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(
                new Error(exceptions.GeneralException.getCode(), exceptions.GeneralException.getError()), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
