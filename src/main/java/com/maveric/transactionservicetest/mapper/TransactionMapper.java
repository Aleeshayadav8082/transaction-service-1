package com.maveric.transactionservicetest.mapper;

import com.maveric.transactionservicetest.dto.TransactionDto;
import com.maveric.transactionservicetest.model.Transaction;
import org.mapstruct.Mapper;

import java.util.List;
import org.springframework.stereotype.Component;

@Mapper(componentModel="Transaction")
@Component
public interface TransactionMapper {

    Transaction map(TransactionDto transactionDto);

    TransactionDto map(Transaction transaction);

    List<Transaction> map (List<TransactionDto> transactions);
}

