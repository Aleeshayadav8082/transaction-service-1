package com.maveric.transactionservicetest.service;

import com.maveric.transactionservicetest.mapper.TransactionMapperImpl;
import com.maveric.transactionservicetest.dto.TransactionDto;
import com.maveric.transactionservicetest.exception.AccountIdMismatchException;
import com.maveric.transactionservicetest.exception.TransactionIdNotFoundException;
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

    public TransactionDto createTransaction(TransactionDto transactionDto, String accountId) {
        if (accountId.equals(transactionDto.getAccountId())) {
            Transaction transaction = transactionMapper.dtoToModel(transactionDto);
            return transactionMapper.modelToDto(transactionRepository.save(transaction));
        } else {
            try {
                throw new AccountIdMismatchException("The account ID " + accountId + " mismatched with the provided data");
            } catch (AccountIdMismatchException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<TransactionDto> getTransactionByAccountId(int page, int pageSize, String accountId) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Transaction> transactionPage = transactionRepository.findTransactionByAccountId(pageable, accountId);

        List<Transaction> transactionList = transactionPage.getContent();
        return transactionList.stream().map(transaction -> transactionMapper.modelToDto(transaction)).collect(Collectors.toList());
    }

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

    @Override
    public void deleteTransactionIdByAccountId(String accountId, String transactionId) throws TransactionIdNotFoundException, AccountIdMismatchException {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(
                () -> new TransactionIdNotFoundException("Transaction ID not available")
        );
        if(accountId.equals(transaction.getAccountId())) {
            transactionRepository.deleteById(transactionId);
        } else {
            throw new AccountIdMismatchException("Account ID not available");
        }
    }
}