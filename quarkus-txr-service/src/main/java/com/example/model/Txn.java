package com.example.model;

import java.time.LocalDateTime;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Txn extends PanacheMongoEntity {

	private double amount;
	private LocalDateTime localDateTime;
	private TxnType type;
	private String account;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public TxnType getType() {
		return type;
	}

	public void setType(TxnType type) {
		this.type = type;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
