package com.maveric.transactionservicetest.model;

import com.maveric.transactionservicetest.constants.Type;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Document(collection = "transaction-service")
public class Transaction {

    @Id
    private String _id;
    private String accountId;
    private Type type;
    private Number amount;
    private String createdAt;

}
