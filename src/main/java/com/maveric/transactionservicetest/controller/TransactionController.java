package com.maveric.transactionservicetest.controller;

import com.maveric.transactionservicetest.exception.AccountIdMismatchException;
import com.maveric.transactionservicetest.exception.TransactionIdNotFoundException;
import com.maveric.transactionservicetest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @DeleteMapping("/accounts/{accountId}/transactions/{transactionId}")
    public ResponseEntity<String> deleteTransactionByAccountId(@PathVariable("accountId") String accountId,
                                                               @PathVariable("transactionId") String transactionId)
            throws TransactionIdNotFoundException, AccountIdMismatchException {
        transactionService.deleteTransactionIdByAccountId(accountId, transactionId);
        return new ResponseEntity<>("Transaction deleted successfully", HttpStatus.OK);
    }

}