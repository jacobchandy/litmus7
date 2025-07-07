package com.litmus7.userregistration.ui;

import java.util.Scanner;

import com.litmus7.userregistration.controller.UserController;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.dto.UserResponse;

/**
 * The main application UI for User registration system. It handles the
 * interaction between user and the system.
 */
public class RegistrationApp {
	public static void main(String[] args) {
		UserController userController = new UserController();

		Scanner scanner = new Scanner(System.in);

		// Scanning for input details
		System.out.println("Enter Username: ");
		String username = scanner.nextLine();

		System.out.println("Enter age: ");
		int age = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter email: ");
		String email = scanner.nextLine();

		System.out.println("Enter password: ");
		String password = scanner.nextLine();

		// Calling the register method
		UserResponse<User> response1 = userController.registerUser(username, age, email, password);

		if (response1.getStatusCode() == 200) {
			User user = response1.getData();
			System.out.println(response1.getSuccessMessage() + user);
		} else {
			System.out.println(response1.getErrorMessage() + "\nRegistration Failed");
		}
		scanner.close();
	}
}
