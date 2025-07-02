package com.litmus7.vrs2.service;

import java.util.ArrayList;
import java.util.List;

import com.litmus7.vrs2.dao.VehicleFileDao;
import com.litmus7.vrs2.dto.Vehicle;
import com.litmus7.vrs2.exception.VehicleDataAccessException;
import com.litmus7.vrs2.exception.VehicleServiceException;

/**
 * Service Class contains the business logic of the Vehicle Rental System.
 * Handles operations to loading from file, adding, searching, renting, and
 * returning vehicles.
 */
public class VehicleService {
	private VehicleFileDao vehicleFileDao = new VehicleFileDao();
	private List<Vehicle> vehicleList = new ArrayList<Vehicle>();

	/**
	 * To load the vehicles from the text file and add them to the List
	 * 
	 * @param filePath Path for the vehicle file
	 * @return vehicleList
	 */
	public List<Vehicle> getVehiclesFromFile(String filePath) throws VehicleServiceException {
		try {
			vehicleList = vehicleFileDao.loadVehiclesFromFile(filePath);
		} catch (VehicleDataAccessException e) {
			throw new VehicleServiceException(e.getMessage(), e);
		}
		return vehicleList;
	}

	/**
	 * Add Vehicles to the List
	 * 
	 * @param vehicle
	 */
	public void addVehicle(Vehicle vehicle) throws VehicleServiceException {
		if (!vehicleList.contains(vehicle)) {
			vehicleList.add(vehicle);
			return;
		}

		throw new VehicleServiceException("Vehicle Already Exists");

	}

	/**
	 * Return the VehicleList
	 * 
	 * @return vehicleList
	 */
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	/**
	 * \ Search Vehicles by Brand name
	 * 
	 * @param brand
	 * @return searchVehicles
	 * @throws VehicleServiceException
	 */
	public List<Vehicle> searchVehicle(String brand) throws VehicleServiceException {
		List<Vehicle> searchVehicles = new ArrayList<Vehicle>();
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.getBrand().equalsIgnoreCase(brand)) {
				searchVehicles.add(vehicle);
			}
		}
		if (searchVehicles.isEmpty()) {
			throw new VehicleServiceException("No vehicles found with brand: " + brand);
		}
		return searchVehicles;
	}

	/**
	 * Search By brand and model
	 * 
	 * @param brand
	 * @param model
	 * @return vehicle
	 * @throws VehicleServiceException
	 */
	public Vehicle searchVehicleByBrandModel(String brand, String model) throws VehicleServiceException {
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.getBrand().equalsIgnoreCase(brand) && vehicle.getModel().equalsIgnoreCase(model)) {
				return vehicle;
			}
		}
		throw new VehicleServiceException("Vehicle with brand: " + brand + " and model: " + model + " not found");
	}

	/**
	 * Rent a Vehicle
	 * 
	 * @param brand
	 * @param model
	 * @throws VehicleServiceException
	 */
	public void rentVehicle(String brand, String model) throws VehicleServiceException {
		Vehicle vehicle = searchVehicleByBrandModel(brand, model);
		if (vehicle.isAvailable()) {
			vehicle.setAvailable(false);
		} else {
			throw new VehicleServiceException("Vehicle already rented");
		}
	}

	/**
	 * Return the rented vehicle
	 * 
	 * @param brand
	 * @param model
	 * @throws VehicleServiceException
	 */
	public void returnVehicle(String brand, String model) throws VehicleServiceException {
		Vehicle vehicle = searchVehicleByBrandModel(brand, model);
		if (!vehicle.isAvailable()) {
			vehicle.setAvailable(true);
		} else {
			throw new VehicleServiceException("Vehicle has not been rented for return");
		}
	}

	/**
	 * Get all available vehicles from the list
	 * 
	 * @return availableVehicles
	 * @throws VehicleServiceException
	 */
	public List<Vehicle> getAvailableVehicle() throws VehicleServiceException {
		List<Vehicle> availableVehicles = new ArrayList<Vehicle>();
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.isAvailable())
				availableVehicles.add(vehicle);
		}
		if (availableVehicles.isEmpty())
			throw new VehicleServiceException("No vehicles are available");
		return availableVehicles;
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
