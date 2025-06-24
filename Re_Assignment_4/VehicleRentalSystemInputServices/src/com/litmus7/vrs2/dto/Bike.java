package com.litmus7.vrs2.dto;

import java.util.Scanner;

/**
 * Bike class inheriting common vehicle attributes and adding engine capacity
 * and gear information.
 */
public class Bike extends Vehicle {
	private boolean hasGear;
	private int engineCapacity;

	/**
	 * Default Constructor
	 */
	public Bike() {
		super();
		this.hasGear = true;
		this.engineCapacity = 150;
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param brand             Bike Brand
	 * @param model             Bike Model
	 * @param rentalPricePerDay Rent for a day
	 * @param hasGear           has gear or not
	 * @param engineCapacity    Engine CC
	 */
	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
		super(brand, model, rentalPricePerDay);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;
	}

	/**
	 * Input bike details
	 */
	public void inputDetails(Scanner scanner) {
		super.inputDetails(scanner);

		System.out.print("Does it have gears (true/false)?: ");
		this.hasGear = scanner.nextBoolean();
		scanner.nextLine();

		System.out.print("Enter engine capacity (cc): ");
		this.engineCapacity = scanner.nextInt();

	}

	/**
	 * Display car details
	 */
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Has Gear: " + this.hasGear);
		System.out.println("Engine Capacity: " + this.engineCapacity + "(cc)");
		System.out.println();
	}
}
