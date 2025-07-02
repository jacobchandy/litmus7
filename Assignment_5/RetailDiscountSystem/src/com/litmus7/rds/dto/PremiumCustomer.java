package com.litmus7.rds.dto;

public class PremiumCustomer implements Discountable{

	@Override
	public double applyDiscount(double totalAmount) {
		if (totalAmount > 5000) {
			totalAmount -= totalAmount*10/100;

		}
		else {
			totalAmount -= totalAmount*7/100;
		}
		return totalAmount;
	}

}
