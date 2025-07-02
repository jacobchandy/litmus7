package com.litmus7.rds.dto;

public class WholesaleCustomer implements Discountable{

	@Override
	public double applyDiscount(double totalAmount) {
		if (totalAmount > 10000) {
			totalAmount -= totalAmount*15/100;

		}
		else {
			totalAmount -= totalAmount*10/100;
		}
		return totalAmount;
	}

}
