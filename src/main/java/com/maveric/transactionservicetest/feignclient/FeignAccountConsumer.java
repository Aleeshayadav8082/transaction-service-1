package com.maveric.transactionservicetest.feignclient;

import com.maveric.transactionservicetest.dto.AccountDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "feign-account",url = "http://localhost:3010/api/v1/")
public interface FeignAccountConsumer {
    @GetMapping("customers/{customerId}/accounts/{accountId}")
    public AccountDto getAccount(@PathVariable("customerId") String customerId,
                                 @Valid @PathVariable("accountId") String accountId);
}