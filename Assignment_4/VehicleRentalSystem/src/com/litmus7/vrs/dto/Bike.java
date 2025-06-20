package com.litmus7.vrs.dto;

import java.util.Scanner;

/**
 * Bike class inheriting common vehicle attributes and adding engine capacity
 * and gear information.
 */
public class Bike extends Vehicle {
	private int engineCapacity;
	private boolean hasGear;

	/**
	 * Default Constructor
	 */
	public Bike() {
		super();
		this.engineCapacity = 150;
		this.hasGear = true;
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param brand             Bike Brand
	 * @param model             Bike Model
	 * @param rentalPricePerDay Rent for a day
	 * @param engineCapacity    Engine CC
	 * @param hasGear           has gear or not
	 */
	public Bike(String brand, String model, double rentalPricePerDay, int engineCapacity, boolean hasGear) {
		super(brand, model, rentalPricePerDay);
		this.engineCapacity = engineCapacity;
		this.hasGear = hasGear;
	}

	/**
	 * Input bike details
	 */
	public void inputDetails(Scanner scanner) {
		super.inputDetails(scanner);

		System.out.print("Enter engine capacity (cc): ");
		this.engineCapacity = scanner.nextInt();

		System.out.print("Does it have gears (true/false)?: ");
		this.hasGear = scanner.nextBoolean();
	}

	/**
	 * Display car details
	 */
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Engine Capacity: " + this.engineCapacity + "(cc)");
		System.out.println("Has Gear: " + this.hasGear);
	}
}
