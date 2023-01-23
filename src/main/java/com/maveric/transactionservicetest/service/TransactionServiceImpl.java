package com.maveric.transactionservicetest.service;

import com.maveric.transactionservicetest.mapper.TransactionMapper;
import com.maveric.transactionservicetest.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    TransactionRepository repository;
    @Autowired
    private TransactionMapper mapper;
}
