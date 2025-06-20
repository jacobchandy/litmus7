package com.litmus7.vrs.dto;

import java.util.Scanner;

/**
 * Car class which inherits vehicle attributes and additional attributes like
 * number of doors and is Automatic or not
 */
public class Car extends Vehicle {
	private int numberOfDoors;
	private boolean isAutomatic;

	/**
	 * Default Constructor
	 */
	public Car() {
		super();
		this.numberOfDoors = 4;
		this.isAutomatic = false;

	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param brand             Car Brand
	 * @param model             Car Model
	 * @param rentalPricePerDay Rent for a day
	 * @param numberOfDoors     Number of doors in a car
	 * @param isAutomatic       Automatic Transmission or not
	 */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	/**
	 * Input the car details
	 */
	public void inputDetails(Scanner scanner) {
		super.inputDetails(scanner);

		System.out.print("Enter number of doors: ");
		this.numberOfDoors = scanner.nextInt();

		System.out.print("Is it automatic (true/false)?: ");
		this.isAutomatic = scanner.nextBoolean();
		scanner.nextLine();
	}

	/**
	 * Display the car details
	 */
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Number of Doors: " + this.numberOfDoors);
		System.out.println("Automatic: " + this.isAutomatic);
		System.out.println();
	}

}
