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
		VehicleResponse response = vehicleController.getVehiclesFromFile("vehicles.txt");

		if (response.getStatusCode() == 200) {
			System.out.println("Loaded Successfully...");
			System.out.println("Vehicle List");
			List<Vehicle> vehicles = response.getVehicles();
			for (Vehicle vehicle : vehicles) {
				System.out.println(vehicle);
			}
		} else {
			System.out.println(response.getErrorMessage());
		}

		// Add a vehicle to list
		System.out.println("\nAdding a Vehicle to List...");
		VehicleResponse response2 = vehicleController.addVehicleToList(new Bike("Suzuki", "GSR", 42, true, 200));
		if (response2.getStatusCode() == 200) {
			System.out.println("Vehicle Added Successfully");
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
		VehicleResponse response3 = vehicleController.searchVehicle("Suzuki");
		if (response3.getStatusCode() == 200) {
			List<Vehicle> brandVehicles = response3.getVehicles();
			for (Vehicle newVehicle : brandVehicles) {
				System.out.println(newVehicle);
			}
		} else {
			System.out.println(response3.getErrorMessage());
		}

		// Rent a vehicle
		System.out.println("\nRenting a Vehicle..");
		VehicleResponse response4 = vehicleController.rentVehicle("Honda", "CBR");
		if (response4.getStatusCode() == 200) {
			System.out.println("Vehicle rented successfully");
		} else {
			System.out.println(response4.getErrorMessage());
		}

		// Return back the vehicle
		System.out.println("\nReturn a Vehicle");
		VehicleResponse response5 = vehicleController.returnVehicle("Suzuki", "GSX");
		if (response5.getStatusCode() == 200) {
			System.out.println("Vehicle returned successfully");
		} else {
			System.out.println(response5.getErrorMessage());
		}

		// Get all available vehicles
		System.out.println("\nGet All Available Vehicles");
		VehicleResponse response6 = vehicleController.getAvailableVehicle();
		if (response6.getStatusCode() == 200) {
			for (Vehicle vehicle : response6.getVehicles()) {
				System.out.println(vehicle);
			}
		} else {
			System.out.println(response6.getErrorMessage());
		}
	}
}