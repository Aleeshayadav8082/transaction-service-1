package com.maveric.transactionservicetest.service;

import com.maveric.transactionservicetest.dto.TransactionDto;

public interface TransactionService {
    public TransactionDto createTransaction(TransactionDto transaction);
}
