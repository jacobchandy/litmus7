package com.litmus7.rds;

import java.util.Scanner;

import com.litmus7.rds.dto.*;

public class RetailStoreApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the customer type (1-Regular, 2-Premium, 3-Wholesale): ");
		
		int type = sc.nextInt();
		
		System.out.println("Ente the total Amount ");
		double totalAmount = sc.nextInt();
		
		Discountable customer = null;
		switch(type) {
			case 1: 
			{
				customer = new RegularCustomer();
				break;
			}
			case 2: 
			{
				customer = new PremiumCustomer();
				break;
			}
			case 3:
				customer = new WholesaleCustomer();
				break;
		}
		double finalAmount = customer.applyDiscount(totalAmount);
		
		System.out.println("Original Amount: ₹" + totalAmount);
	    System.out.println("Discount Applied: ₹" + (totalAmount - finalAmount));
	    System.out.println("Final Payable Amount: ₹" + finalAmount);
		
	}

}
