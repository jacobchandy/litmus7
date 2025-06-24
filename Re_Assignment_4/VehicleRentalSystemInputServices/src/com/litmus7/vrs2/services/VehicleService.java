package com.litmus7.vrs2.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vrs2.dto.Bike;
import com.litmus7.vrs2.dto.Car;
import com.litmus7.vrs2.dto.Vehicle;

/**
 * Service Class to load vehicles from a file, add them to a List and display
 * them. Also other features like calculating total Rent per Day
 */
public class VehicleService {
	private List<Vehicle> vehicleList = new ArrayList<Vehicle>();

	/**
	 * To load the vehicles from the text file and add them to the List
	 * 
	 * @param filePath Path for the vehicle file
	 */
	public void loadVehiclesFromFile(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");

				if (parts.length == 6) {
					if ("Car".equals(parts[0])) {
						String brand = parts[1];
						String model = parts[2];
						double rentalPricePerDay = Double.parseDouble(parts[3]);
						int numberOfDoors = Integer.parseInt(parts[4]);
						boolean isAutomatic = Boolean.parseBoolean(parts[5]);

						vehicleList.add(new Car(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic));

					} else if ("Bike".equals(parts[0])) {
						String brand = parts[1];
						String model = parts[2];
						double rentalPricePerDay = Double.parseDouble(parts[3]);
						boolean hasGear = Boolean.parseBoolean(parts[4]);
						int engineCapacity = Integer.parseInt(parts[5]);

						vehicleList.add(new Bike(brand, model, rentalPricePerDay, hasGear, engineCapacity));
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading vehicles file: " + e.getMessage());
		}
	}

	/**
	 * Add Vehicles to the List
	 * 
	 * @param vehicle
	 */
	public void addVehicle(Vehicle vehicle) {
		vehicleList.add(vehicle);
	}

	/**
	 * Display the Vehicles
	 */
	public void displayVehicles() {
		for (Vehicle v : vehicleList) {
			v.displayDetails();
		}
	}

	/**
	 * Calculate total rent
	 * 
	 * @return total Total Rent for the day
	 */
	public double calculateTotalRent() {
		double total = 0;
		for (Vehicle v : vehicleList) {
			total += v.getRentalPricePerDay();
		}
		return total;
	}
}
