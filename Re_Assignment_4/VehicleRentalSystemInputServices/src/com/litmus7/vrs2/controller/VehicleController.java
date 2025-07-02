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
	private VehicleService vehicleService = new VehicleService();

	/**
	 * Get Vehicles from the file
	 * 
	 * @param filePath
	 * @return response
	 */
	public VehicleResponse<List<Vehicle>> getVehiclesFromFile(String filePath) {
		VehicleResponse<List<Vehicle>> response = new VehicleResponse<List<Vehicle>>();
		List<Vehicle> vehicles = null;

		try {
			vehicles = vehicleService.getVehiclesFromFile(filePath);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setData(vehicles);
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Failed to load the file: " + e.getMessage());
		}
		return response;
	}

	/**
	 * Adds the vehicle to the List
	 * 
	 * @param vehicle
	 * @return response
	 */
	public VehicleResponse<String> addVehicleToList(Vehicle vehicle) {
		VehicleResponse<String> response = new VehicleResponse<String>();

		if (vehicle.getBrand() == null || vehicle.getBrand().isBlank() || vehicle.getModel() == null
				|| vehicle.getModel().isBlank()) {
			response.setErrorMessage("Invalid Vehicle Data");
			response.setStatusCode(ERROR_STATUS_CODE);
			return response;
		}

		try {
			vehicleService.addVehicle(vehicle);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setData("Vehicle Added Successfully");
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
	public VehicleResponse<List<Vehicle>> searchVehicle(String brand) {
		VehicleResponse<List<Vehicle>> response = new VehicleResponse<List<Vehicle>>();
		if (brand == null || brand.isBlank()) {
			response.setErrorMessage("Brand and model must not be blank");
			response.setStatusCode(ERROR_STATUS_CODE);
			return response;
		}

		try {
			List<Vehicle> vehicle = vehicleService.searchVehicle(brand);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setData(vehicle);
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
	public VehicleResponse<String> rentVehicle(String brand, String model) {
		VehicleResponse<String> response = new VehicleResponse<String>();
		if (brand == null || brand.isBlank() || model == null || model.isBlank()) {
			response.setErrorMessage("Brand and model must not be blank");
			response.setStatusCode(ERROR_STATUS_CODE);
		}

		try {
			vehicleService.rentVehicle(brand, model);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setData("Vehicle rented successfully");
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
	public VehicleResponse<String> returnVehicle(String brand, String model) {
		VehicleResponse<String> response = new VehicleResponse<String>();
		if (brand == null || brand.isBlank() || model == null || model.isBlank()) {
			response.setErrorMessage("Brand and model must not be blank");
			response.setStatusCode(ERROR_STATUS_CODE);
		}

		try {
			vehicleService.returnVehicle(brand, model);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setData("Vehicle returned successfully");
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
	public VehicleResponse<List<Vehicle>> getAvailableVehicle() {
		VehicleResponse<List<Vehicle>> response = new VehicleResponse<List<Vehicle>>();

		try {
			response.setData(vehicleService.getAvailableVehicle());
			response.setStatusCode(SUCCESS_STATUS_CODE);
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
}
