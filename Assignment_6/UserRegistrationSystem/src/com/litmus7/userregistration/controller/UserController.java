package com.litmus7.userregistration.controller;

import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.dto.UserResponse;
import com.litmus7.userregistration.exception.InvalidAgeException;
import com.litmus7.userregistration.exception.InvalidEmailException;
import com.litmus7.userregistration.exception.UserServiceException;
import com.litmus7.userregistration.exception.WeakPasswordException;
import com.litmus7.userregistration.service.UserService;

/**
 * Controller class coordinates between UI and Service Layer. Handles input
 * validations, service layers methods and packages the results into
 * {@link UserResponse} objects for the UI
 * 
 */
public class UserController {
	private static final int SUCCESS_STATUS_CODE = 200;
	private static final int ERROR_STATUS_CODE = 400;
	private UserService userService = new UserService();

	/**
	 * Validating the user data and registering into the database
	 * 
	 * @param username
	 * @param age
	 * @param email
	 * @param password
	 * @return
	 */
	public UserResponse<User> registerUser(String username, int age, String email, String password) {
		UserResponse<User> response = new UserResponse<User>();
		if (username == null || username.isBlank()) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Error: Username cant be empty");
			return response;
		}
		if (password == null || password.isBlank()) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Error: Password cant be empty");
			return response;
		}
		try {
			User user = userService.registerUser(username, age, email, password);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setData(user);
			response.setSuccessMessage("Registered Successfully!! ");
		} catch (InvalidAgeException | InvalidEmailException | WeakPasswordException | UserServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Error: " + e.getMessage());
		}
		return response;
	}

}
