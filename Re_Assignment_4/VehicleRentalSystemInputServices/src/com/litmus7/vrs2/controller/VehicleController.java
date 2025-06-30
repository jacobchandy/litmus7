package com.litmus7.vrs2.controller;

import java.util.List;

import com.litmus7.vrs2.dto.*;
import com.litmus7.vrs2.exception.VehicleServiceException;
import com.litmus7.vrs2.service.VehicleService;

/**
 * Controller class coordinates between UI and Service Layer. Handles input
 * validations, service layers methods and packages the results into
 * {@link VehicleResponse} objects for the UI
 * 
 */
public class VehicleController {
	private static final int SUCCESS_STATUS_CODE = 200;
	private static final int ERROR_STATUS_CODE = 400;
	VehicleService vehicleService = new VehicleService();

	/**
	 * Get Vehicles from the file
	 * 
	 * @param filePath
	 * @return response
	 */
	public VehicleResponse getVehiclesFromFile(String filePath) {
		VehicleResponse response = new VehicleResponse();
		List<Vehicle> vehicles = null;

		try {
			vehicles = vehicleService.getVehiclesFromFile(filePath);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setVehicles(vehicles);
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Could not load vehicles from file");
		}
		return response;
	}

	/**
	 * Adds the vehicle to the List
	 * 
	 * @param vehicle
	 * @return response
	 */
	public VehicleResponse addVehicleToList(Vehicle vehicle) {
		VehicleResponse response = new VehicleResponse();

		if (vehicle.getBrand().isBlank() || vehicle.getModel().isBlank()) {
			response.setErrorMessage("Invalid Vehicle Data");
			response.setStatusCode(ERROR_STATUS_CODE);
			return response;
		}

		try {
			vehicleService.addVehicle(vehicle);
			response.setStatusCode(SUCCESS_STATUS_CODE);
		} catch (VehicleServiceException e) {
			response.setErrorMessage(e.getMessage());
			response.setStatusCode(ERROR_STATUS_CODE);
		}
		return response;
	}

	/**
	 * Gets the Vehicle List from Service Layer
	 * 
	 * @return response
	 */
	public List<Vehicle> getVehicleList() {
		return vehicleService.getVehicleList();
	}

	/**
	 * Search a Vehicle using brand name
	 * 
	 * @param brand
	 * @return response
	 */
	public VehicleResponse searchVehicle(String brand) {
		VehicleResponse response = new VehicleResponse();

		try {
			List<Vehicle> vehicle = vehicleService.searchVehicle(brand);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setVehicles(vehicle);
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	/**
	 * Rent a Vehicle using brand and model
	 * 
	 * @param brand
	 * @param model
	 * @return response
	 */
	public VehicleResponse rentVehicle(String brand, String model) {
		VehicleResponse response = new VehicleResponse();

		try {
			vehicleService.rentVehicle(brand, model);
			response.setStatusCode(SUCCESS_STATUS_CODE);
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	/**
	 * Return the rented vehicle
	 * 
	 * @param brand
	 * @param model
	 * @return response
	 */
	public VehicleResponse returnVehicle(String brand, String model) {
		VehicleResponse response = new VehicleResponse();

		try {
			vehicleService.returnVehicle(brand, model);
			response.setStatusCode(SUCCESS_STATUS_CODE);
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	/**
	 * Get all the available vehicles
	 * 
	 * @return response
	 */
	public VehicleResponse getAvailableVehicle() {
		VehicleResponse response = new VehicleResponse();

		try {
			response.setVehicles(vehicleService.getAvailableVehicle());
			response.setStatusCode(SUCCESS_STATUS_CODE);
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
}
