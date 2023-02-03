package com.maveric.transactionservicetest.service;

import com.maveric.transactionservicetest.dto.TransactionDto;
import com.maveric.transactionservicetest.exception.AccountIdMismatchException;
import com.maveric.transactionservicetest.exception.TransactionIdNotFoundException;
import java.util.List;
public interface TransactionService {

    TransactionDto createTransaction (TransactionDto transactionDto, String accountId);

    List<TransactionDto> getTransactionByAccountId(int page, int pageSize, String accountId);

    TransactionDto getTransactionIdByAccountId(String accountId, String transactionId) throws TransactionIdNotFoundException, AccountIdMismatchException;

    void deleteTransactionIdByAccountId(String accountId, String transactionId) throws TransactionIdNotFoundException, AccountIdMismatchException;

    void deleteAllTransactionsByAccountId(String accountId);
}