package com.maveric.transactionservicetest.exception;

public class TransactionIdNotFoundException extends Exception{
    public TransactionIdNotFoundException(String message) {
        super(message);
    }
}