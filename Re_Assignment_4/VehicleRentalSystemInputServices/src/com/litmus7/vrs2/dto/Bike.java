package com.litmus7.vrs2.dto;

/**
 * Bike class inheriting common vehicle attributes and adding engine capacity
 * and gear information.
 */
public class Bike extends Vehicle {
	private boolean hasGear;
	private int engineCapacity;

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

	@Override
	public String toString() {
		return "Bike => " + super.toString() + " | hasGear: " + hasGear + " | engineCapacity: " + engineCapacity;
	}
}
