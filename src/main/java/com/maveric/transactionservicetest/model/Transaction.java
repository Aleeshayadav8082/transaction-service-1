package com.maveric.transactionservicetest.model;

import com.maveric.transactionservicetest.constants.Type;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Document(collection = "transaction")
public class Transaction {

    @Id
    private String _id;

    private String accountId;

    private Number amount;

    @Enumerated(EnumType.STRING)
    private Type type;

    private LocalDateTime createdAt = LocalDateTime.now();
}