package com.example;

import java.util.List;

import com.example.bill.Billing;
import com.example.bill.BillingImpl;
import com.example.pm.PriceMatrix;
import com.example.pm.PriceMatrix_v1;
import com.example.pm.PriceMatrix_v2;

public class App {

	public static void main(String[] args) {

		// init
		PriceMatrix priceMatrixV1 = new PriceMatrix_v1();
		PriceMatrix priceMatrixV2 = new PriceMatrix_v2();
		Billing billingComp = new BillingImpl(priceMatrixV2);

		// use
		List<String> cart1 = List.of("123123", "3434234");
		double totalPrice = billingComp.getTotalPrice(cart1);
		System.out.println(totalPrice);

		// destroy
		// ....

	}

}
