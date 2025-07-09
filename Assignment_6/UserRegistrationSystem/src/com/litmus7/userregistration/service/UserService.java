package com.litmus7.userregistration.service;

import java.util.regex.Pattern;

import com.litmus7.userregistration.dao.UserDao;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.*;

/**
 * Service Class contains the business logic of the User Registration System.
 * Handles operations to registration and validating the user.
 */
public class UserService {
	private UserDao userDao = new UserDao();
	private static final int LOWER_AGE_LIMIT = 18;
	private static final int UPPER_AGE_LIMIT = 60;
	private static final int PASSWORD_LENGTH = 6;
	private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	/**
	 * Registering the user into the database
	 * 
	 * @param username
	 * @param age
	 * @param email
	 * @param password
	 * @return User object
	 * @throws InvalidAgeException
	 * @throws InvalidEmailException
	 * @throws WeakPasswordException
	 * @throws UserServiceException
	 */
	public User registerUser(String username, int age, String email, String password)
			throws InvalidAgeException, InvalidEmailException, WeakPasswordException, UserServiceException {

		validateUser(age, email, password);
		User user = new User(username, age, email, password);

		try {
			if (userDao.getUser(email, username)) {
				throw new UserServiceException("A user already exists");
			}
			userDao.addUserToDB(user);
		} catch (UserDataAccessException e) {
			throw new UserServiceException("Failed to register user: " + e.getMessage(), e);
		}
		return user;
	}

	/**
	 * Validating the User. Checking for age, email, and password.
	 * 
	 * @param age
	 * @param email
	 * @param password
	 * @throws InvalidAgeException
	 * @throws InvalidEmailException
	 * @throws WeakPasswordException
	 */
	public void validateUser(int age, String email, String password)
			throws InvalidAgeException, InvalidEmailException, WeakPasswordException {

		if (age < LOWER_AGE_LIMIT || age > UPPER_AGE_LIMIT) {
			throw new InvalidAgeException("Age must be within " + LOWER_AGE_LIMIT + " and " + UPPER_AGE_LIMIT);
		}

		if (!EMAIL_PATTERN.matcher(email).matches()) {
			throw new InvalidEmailException("Invalid email format.");
		}

		if (password.length() < PASSWORD_LENGTH) {
			throw new WeakPasswordException("Password is weak! Must be at least " + PASSWORD_LENGTH + " characters.");
		}
	}
}
