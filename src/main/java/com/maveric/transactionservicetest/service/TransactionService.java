package com.maveric.transactionservicetest.service;

import com.maveric.transactionservicetest.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
    List<TransactionDto> getTransactionByAccountId(int page, int pageSize, String accountId);
}
