package com.litmus7.vrs;

import java.util.Scanner;

import com.litmus7.vrs.dto.Bike;
import com.litmus7.vrs.dto.Car;

/**
 * The main application class for Vehicle rental system. It inputs and displays
 * details of Car and Bike vehicles.
 */
public class VehicleApp {
	public static void main(String[] args) {
		// Using default constructor
		Scanner scanner = new Scanner(System.in);
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
		Bike bike2 = new Bike("Suzuki", "Gixxer", 600.0, 125, false);

		System.out.println("\n--- Displaying Car Details (Parameterized) ---");
		car2.displayDetails();

		System.out.println("\n--- Displaying Bike Details (Parameterized) ---");
		bike2.displayDetails();

		scanner.close();
	}

}
