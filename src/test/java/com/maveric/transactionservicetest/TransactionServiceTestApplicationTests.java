package com.maveric.transactionservicetest;

import com.maveric.transactionservicetest.constants.AccountType;
import com.maveric.transactionservicetest.constants.Type;
import com.maveric.transactionservicetest.dto.AccountDto;
import com.maveric.transactionservicetest.dto.TransactionDto;
import com.maveric.transactionservicetest.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class TransactionServiceTestApplicationTests {

	@Test
	void contextLoads() {
	}

	public static Transaction getTransaction(){
		Transaction transaction = new Transaction();
		transaction.set_id("1234");
		transaction.setType(Type.CREDIT);
		transaction.setAccountId("maveric-1");
		transaction.setAmount(872.32);
		transaction.setCreatedAt(LocalDateTime.now());
		return transaction;
	}

	public static Transaction getTransactionInvalidData(){
		Transaction transaction = new Transaction();
		transaction.set_id("1234");
		transaction.setType(Type.CREDIT);
		transaction.setAccountId("maveric-1");
		transaction.setAmount(-1);
		transaction.setCreatedAt(LocalDateTime.now());
		return transaction;
	}

	public static TransactionDto getTransactionDtoInvalidData(){
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.set_id("1234");
		transactionDto.setType(Type.CREDIT);
		transactionDto.setAccountId("");
		transactionDto.setAmount(872.32);
		transactionDto.setCreatedAt(LocalDateTime.now());
		return transactionDto;
	}

	public static TransactionDto getTransactionDto()
	{
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.set_id("1234");
		transactionDto.setType(Type.CREDIT);
		transactionDto.setAccountId("maveric-1");
		transactionDto.setAmount(872.32);
		transactionDto.setCreatedAt(LocalDateTime.now());
		return transactionDto;
	}

	public static AccountDto getAccountDto(){
		AccountDto accountDto = new AccountDto();
		accountDto.set_id("1234");
		accountDto.setCustomerId("1234");
		accountDto.setType(AccountType.CURRENT);
		return accountDto;
	}

}