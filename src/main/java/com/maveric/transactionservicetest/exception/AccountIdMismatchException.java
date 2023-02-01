package com.maveric.transactionservicetest.exception;

public class AccountIdMismatchException extends RuntimeException{
    public AccountIdMismatchException(String message) {
        super(message);
    }
}