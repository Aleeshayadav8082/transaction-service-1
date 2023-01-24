package com.maveric.transactionservicetest.dto;

import com.maveric.transactionservicetest.constants.Type;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class TransactionDto {
    private String _id;
    @NotBlank(message = "Account Id required")
    private String accountId;
    @NotNull(message = "Type is mandatory - 'CREDIT' or 'DEBIT'")
    private Type type;
    @NotNull(message = "Amount required")
    @Min(value=1,message = "Amount cannot be less than or equal to zero")
    private Number amount;
    private LocalDateTime createdAt = LocalDateTime.now();
}
