package com.example.service;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.example.model.Account;
import com.example.model.Txn;
import com.example.model.TxnType;

import io.quarkus.narayana.jta.runtime.TransactionConfiguration;

@ApplicationScoped
public class TxrService {

	@TransactionConfiguration(timeout = 30)
	@Transactional(rollbackOn = {},value = TxType.REQUIRED)
	public void txr(double amount, String fromAccNumber, String toAccNumber) {

		Account fromAccount = Account.findById(fromAccNumber);
		Account toAccount = Account.findById(toAccNumber);

		fromAccount.setBalance(fromAccount.getBalance() - 100.00);
		toAccount.setBalance(toAccount.getBalance() + 100.00);

		Account.update("balance = ?1 where num = ?2", fromAccount.getBalance(), fromAccount.getNum());
		Account.update("balance = ?1 where num = ?2", toAccount.getBalance(), toAccount.getNum());
		
		Txn txn=new Txn();
		txn.setAccount(fromAccNumber);
		txn.setAmount(amount);
		txn.setLocalDateTime(LocalDateTime.now());
		txn.setType(TxnType.DEBIT);
		
		txn.persist();
		

	}

}
