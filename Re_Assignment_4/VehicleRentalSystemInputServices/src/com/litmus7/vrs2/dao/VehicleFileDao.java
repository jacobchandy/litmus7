package com.litmus7.vrs2.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vrs2.dto.*;
import com.litmus7.vrs2.exception.VehicleDataAccessException;

/**
 * Data Access Object (DAO) Layer is used for loading vehicles and other
 * operations from a file. It reads vehicle data and converts to
 * {@link Vehicle}, {@link Car}, {@link Bike} objects .
 */
public class VehicleFileDao {
	/**
	 * Load the vehicles and convert to objects
	 * 
	 * @param filePath
	 * @return vehicleList
	 * @throws VehicleDataAccessException
	 */
	public List<Vehicle> loadVehiclesFromFile(String filePath) throws VehicleDataAccessException {

		List<Vehicle> vehicleList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");

				// Parse the input
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
		} catch (FileNotFoundException e) {
			throw new VehicleDataAccessException(e.getMessage(), e);
		}

		catch (IOException e) {
			throw new VehicleDataAccessException(e.getMessage(), e);
		}

		return vehicleList;
	}
}