package com.maveric.transactionservicetest.service;

import com.maveric.transactionservicetest.dto.TransactionDto;
import com.maveric.transactionservicetest.mapper.TransactionMapper;
import com.maveric.transactionservicetest.mapper.TransactionMapperImpl;
import com.maveric.transactionservicetest.model.Transaction;
import com.maveric.transactionservicetest.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.maveric.transactionservicetest.constants.Constants.getCurrentDateTime;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private TransactionMapper mapper;

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction = mapper.map(transactionDto);
        Transaction transactionResult = repository.save(transaction);
        TransactionDto transactionDtoResult = mapper.map(transactionResult);
        //Adding CreatedTime
        transactionDtoResult.setCreatedAt(getCurrentDateTime());
        return transactionDtoResult;
    }
}