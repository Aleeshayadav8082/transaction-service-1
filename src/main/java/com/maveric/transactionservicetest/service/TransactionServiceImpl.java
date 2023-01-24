package com.maveric.transactionservicetest.service;

import com.maveric.transactionservicetest.mapper.TransactionMapperImpl;
import com.maveric.transactionservicetest.dto.TransactionDto;
import com.maveric.transactionservicetest.exception.AccountIdMismatchException;
import com.maveric.transactionservicetest.exception.TransactionIdNotFoundException;
import com.maveric.transactionservicetest.model.Transaction;
import com.maveric.transactionservicetest.repository.TransactionRepository;
import com.maveric.transactionservicetest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionMapperImpl transactionMapper;

    @Override
    public TransactionDto getTransactionIdByAccountId(String accountId, String transactionId) throws TransactionIdNotFoundException, AccountIdMismatchException {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(
                () -> new TransactionIdNotFoundException("Transaction id not available")
        );
        if(accountId.equals(transaction.getAccountId())) {
            return transactionMapper.modelToDto(transaction);
        } else {
            throw new AccountIdMismatchException("Account Id not available");
        }
    }
}