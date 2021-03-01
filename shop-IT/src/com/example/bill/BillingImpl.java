package com.example.bill;

import java.util.List;

import com.example.pm.PriceMatrix;
import com.example.pm.PriceMatrix_v1;

/*
 * 
 *  design & performance issues
 *  ----------------------------
 *  
 *  1. dependent & dependent are tightly-coupled
 *  	=> can't extend module with new features
 *  2. too many duplicate dependency instance created & destroyed..
 *      => resource waste
 *  3. unit-testing possible
 *  	=> bug-fix/dev slow
 *  
 *  
 *  why we these issues ?
 *  
 *  	
 *  => dependent itself creating it's own dependency in it's home
 *  
 *  solution :
 *  
 *  	==> Don't create dependency in home , get from factory
 *  
 *  limitation with factory-lookup :
 *  
 *  	==> factory location tight coupling
 *  
 *  
 *  best solution :
 *  
 *  	==> don't create / lookup for dependency , 'inject' by other   ( Inversion of Control )
 *  
 * 
 * 
 *   how to implement IOC ?
 *   
 *   
 *   	way-1 : dependency injection
 *      way-2 : aop 
 *   
 *   
 * -------------------------------------------------------------------
 *   OO principles  a.k.a SOLID principles
 * -------------------------------------------------------------------
 * 
 * 
 */

public class BillingImpl implements Billing {

	private PriceMatrix priceMatrix;

	// DI
	public BillingImpl(PriceMatrix priceMatrix) {
		super();
		this.priceMatrix = priceMatrix;
	}

	@Override
	public double getTotalPrice(List<String> cart) {
		double total = 0.0;
		for (String item : cart) {
			total += priceMatrix.getPrice(item);
		}
		return total;
	}

}
