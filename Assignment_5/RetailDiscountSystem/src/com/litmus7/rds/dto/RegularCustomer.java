package com.litmus7.rds.dto;

public class RegularCustomer implements Discountable {
	
	@Override
	public double applyDiscount(double totalAmount) {
		totalAmount = totalAmount - totalAmount*5/100;
		return totalAmount;
	}	
}
