package com.maveric.transactionservicetest.service;

import com.maveric.transactionservicetest.dto.TransactionDto;
import com.maveric.transactionservicetest.exception.AccountIdMismatchException;
import com.maveric.transactionservicetest.exception.TransactionIdNotFoundException;

public interface TransactionService {
    TransactionDto getTransactionIdByAccountId(String accountId, String transactionId) throws TransactionIdNotFoundException, AccountIdMismatchException;
}
