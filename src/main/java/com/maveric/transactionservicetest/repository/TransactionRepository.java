package com.maveric.transactionservicetest.repository;

import com.maveric.transactionservicetest.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction,String> {
}