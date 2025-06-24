package com.litmus7.vrs2;

import java.util.Scanner;

import com.litmus7.vrs2.dto.Bike;
import com.litmus7.vrs2.dto.Car;
import com.litmus7.vrs2.services.VehicleService;

/**
 * The main application class for Vehicle rental system. It loads a file and
 * displays details of Car and Bike vehicles. It also shows the total rent per
 * day of all vehicles.
 */
public class VehicleApp {
	public static void main(String[] args) {
		// Using default constructor
		Scanner scanner = new Scanner(System.in);
		VehicleService service = new VehicleService();

		// Load Vehicle Data from the text file
		service.loadVehiclesFromFile("vehicles.txt");

		// Print the List
		System.out.println("Vehicle List:");
		service.displayVehicles();

		// Manually Adding Vehicles
		System.out.println("Adding vehicles by Input/Parameter constructor");
		Car car1 = new Car();
		System.out.println("--- Enter Car Details ---");
		car1.inputDetails(scanner);

		System.out.println("\n--- Displaying Car Details ---");
		car1.displayDetails();

		Bike bike1 = new Bike();
		System.out.println("--- Enter Bike Details ---");
		bike1.inputDetails(scanner);

		System.out.println("\n--- Displaying Bike Details ---");
		bike1.displayDetails();

		// Using Parameterized Constructor
		Car car2 = new Car("Honda", "Civic", 1400.0, 4, false);
		Bike bike2 = new Bike("Suzuki", "Gixxer", 600.0, false, 125);

		service.addVehicle(car1);
		service.addVehicle(bike1);
		service.addVehicle(car2);
		service.addVehicle(bike2);

		System.out.println("Updated Vehicle List:");
		service.displayVehicles();

		System.out.println("Total Rent Price Per Day for All Vehicles: " + service.calculateTotalRent());
		scanner.close();
	}

}
