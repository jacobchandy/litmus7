package com.litmus7.vrs.dto;

import java.util.Scanner;

/**
 * Vehicle attributes with common attributes like brand, model and rent
 * price/day
 */
public class Vehicle {
	private String brand;
	private String model;
	private double rentalPricePerDay;

	/*
	 * Default Constructor
	 */
	public Vehicle() {
		this.brand = "None";
		this.model = "None";
		this.rentalPricePerDay = 0.0;
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param brand             Vehicle Brand
	 * @param model             Vehicle Model
	 * @param rentalPricePerDay Rent for a Day
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	/**
	 * Input the vehicle details
	 */
	public void inputDetails(Scanner scanner) {
		System.out.print("Enter Brand: ");
		brand = scanner.nextLine();

		System.out.print("Enter model: ");
		model = scanner.nextLine();

		System.out.print("Enter rental price per day: ");
		rentalPricePerDay = scanner.nextDouble();

	}

	/**
	 * Display the vehicle details
	 */
	public void displayDetails() {
		System.out.println("Brand: " + this.brand);
		System.out.println("Model: " + this.model);
		System.out.println("Rent Price/Day: " + this.rentalPricePerDay);
	}

}
