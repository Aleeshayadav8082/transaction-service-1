package com.maveric.transactionservicetest.dto;

import com.maveric.transactionservicetest.constants.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDto {
    private String _id;

    @NotEmpty(message = "Please enter account ID")
    private String accountId;

    @Min(value = 0, message = "Amount cannot be less then 0")
    private Number amount;

    @Enumerated(EnumType.STRING)
    private Type type;

    private LocalDateTime createdAt = LocalDateTime.now();
}