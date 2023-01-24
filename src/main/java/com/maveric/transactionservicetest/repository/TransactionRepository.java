package com.maveric.transactionservicetest.repository;

import com.maveric.transactionservicetest.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findTransactionByAccountId(String accountId);

    Page<Transaction> findTransactionByAccountId(Pageable pageable, String accountId);
}