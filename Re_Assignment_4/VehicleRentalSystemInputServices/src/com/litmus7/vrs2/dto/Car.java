package com.litmus7.vrs2.dto;

/**
 * Car class which inherits vehicle attributes and additional attributes like
 * number of doors and is Automatic or not
 */
public class Car extends Vehicle {
	private int numberOfDoors;
	private boolean isAutomatic;

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

	@Override
	public String toString() {
		return "Car => " + super.toString() + " | numberOfDoors: " + numberOfDoors + " | isAutomatic: " + isAutomatic;
	}
}
