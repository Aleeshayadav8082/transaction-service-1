package com.maveric.transactionservicetest.service;

import com.maveric.transactionservicetest.mapper.TransactionMapperImpl;
import com.maveric.transactionservicetest.dto.TransactionDto;
import com.maveric.transactionservicetest.model.Transaction;
import com.maveric.transactionservicetest.repository.TransactionRepository;
import com.maveric.transactionservicetest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionMapperImpl transactionMapper;

    @Override
    public List<TransactionDto> getTransactionByAccountId(int page, int pageSize, String accountId) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Transaction> transactionPage = transactionRepository.findTransactionByAccountId(pageable, accountId);

        List<Transaction> transactionList = transactionPage.getContent();
        return transactionList.stream().map(transaction
                -> transactionMapper.modelToDto(transaction)).collect(Collectors.toList());
    }
}