package com.example.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Account extends PanacheEntityBase {

	@Id
	private String num;
	private double balance;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public static List<Account> findBigAccounts(){
		return find("balance=?1", 1000.00).list();
	}

	@Override
	public String toString() {
		return "Account [num=" + num + ", balance=" + balance + "]";
	}
	

}
