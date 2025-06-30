package com.litmus7.vrs2.dto;

import java.util.Objects;

/**
 * Vehicle attributes with common attributes like brand, model and rent
 * price/day
 */
public class Vehicle {
	private String brand;
	private String model;
	private double rentalPricePerDay;
	private boolean isAvailable = true;

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

	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Brand: " + brand + " | Model: " + model + " | Rent/Day: " + rentalPricePerDay + " | Available: "
				+ isAvailable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(model, other.model);
	}
}
