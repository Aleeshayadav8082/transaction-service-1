package com.maveric.transactionservicetest.exception;

import com.maveric.transactionservicetest.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(AccountIdMismatchException.class)
    public ResponseEntity<ErrorDto> handleAccountIdMismatchException(AccountIdMismatchException e) {
        ErrorDto error = getError(e.getMessage(), String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TransactionIdNotFoundException.class)
    public ResponseEntity<ErrorDto> handleTransactionIdNotFoundException(TransactionIdNotFoundException e) {
        ErrorDto error = getError(e.getMessage(), String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorDto getError(String message , String code){
        ErrorDto error = new ErrorDto();
        error.setCode(code);
        error.setMessage(message);
        return error;
    }
}