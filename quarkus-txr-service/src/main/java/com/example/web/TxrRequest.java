package com.example.web;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class TxrRequest {

	@Min(value = 1,message = "invalid amount")
	private double amount;
	@NotBlank(message = "from acc required")
	private String fromAccNum;
	@NotBlank(message = "to acc required")
	private String toAccNum;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFromAccNum() {
		return fromAccNum;
	}

	public void setFromAccNum(String fromAccNum) {
		this.fromAccNum = fromAccNum;
	}

	public String getToAccNum() {
		return toAccNum;
	}

	public void setToAccNum(String toAccNum) {
		this.toAccNum = toAccNum;
	}

}
