package com.litmus7.vrs2.ui;

import java.util.List;

import com.litmus7.vrs2.controller.VehicleController;
import com.litmus7.vrs2.dto.Bike;
import com.litmus7.vrs2.dto.Vehicle;
import com.litmus7.vrs2.dto.VehicleResponse;

/**
 * The main application UI for Vehicle rental system. It handles the interaction
 * between user and the system to performs methods such as loading vehicles,
 * searching, renting, adding, returning.
 */
public class VehicleApp {
	public static void main(String[] args) {
		VehicleController vehicleController = new VehicleController();

		// Load vehicles from file
		System.out.println("Loading Vehicles from vehicles.txt....");
		VehicleResponse<List<Vehicle>> response = vehicleController.getVehiclesFromFile("vehicles.txt");

		if (response.getStatusCode() == 200) {
			System.out.println("Loaded Successfully...");
			System.out.println("Vehicle List");
			List<Vehicle> vehicles = response.getData();
			for (Vehicle vehicle : vehicles) {
				System.out.println(vehicle);
			}
		} else {
			System.out.println(response.getErrorMessage());
		}

		// Add a vehicle to list
		System.out.println("\nAdding a Vehicle to List...");
		VehicleResponse<String> response2 = vehicleController
				.addVehicleToList(new Bike("Suzuki", "GSR", 42, true, 200));
		if (response2.getStatusCode() == 200) {
			System.out.println(response2.getData());
		} else {
			System.out.println(response2.getErrorMessage());
		}

		// Vehicle List after adding a vehicle
		System.out.println("\nVehicle List After Adding");
		for (Vehicle vehicle : vehicleController.getVehicleList()) {
			System.out.println(vehicle);
		}

		// Search for vehicles by brand name
		System.out.println("\nSearch for a Brand..");
		VehicleResponse<List<Vehicle>> response3 = vehicleController.searchVehicle("Suzuki");
		if (response3.getStatusCode() == 200) {
			List<Vehicle> brandVehicles = response3.getData();
			for (Vehicle newVehicle : brandVehicles) {
				System.out.println(newVehicle);
			}
		} else {
			System.out.println(response3.getErrorMessage());
		}

		// Rent a vehicle
		System.out.println("\nRenting a Vehicle..");
		VehicleResponse<String> response4 = vehicleController.rentVehicle("Honda", "CBR");
		if (response4.getStatusCode() == 200) {
			System.out.println(response4.getData());
		} else {
			System.out.println(response4.getErrorMessage());
		}

		// Return back the vehicle
		System.out.println("\nReturn a Vehicle");
		VehicleResponse<String> response5 = vehicleController.returnVehicle("Suzuki", "GSX");
		if (response5.getStatusCode() == 200) {
			System.out.println();
		} else {
			System.out.println(response5.getErrorMessage());
		}

		// Get all available vehicles
		System.out.println("\nGet All Available Vehicles");
		VehicleResponse<List<Vehicle>> response6 = vehicleController.getAvailableVehicle();
		if (response6.getStatusCode() == 200) {
			for (Vehicle vehicle : response6.getData()) {
				System.out.println(vehicle);
			}
		} else {
			System.out.println(response6.getErrorMessage());
		}
	}
}