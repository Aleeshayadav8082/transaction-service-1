package com.maveric.transactionservicetest.exception;

public class TransactionAmountException extends RuntimeException{
    public TransactionAmountException(String message) {
        super(message);
    }
}