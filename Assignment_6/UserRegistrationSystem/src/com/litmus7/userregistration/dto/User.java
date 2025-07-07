package com.litmus7.userregistration.dto;

/**
 * User class with common attributes like user name, age email and password
 */
public class User {
	private String username;
	private int age;
	private String email;
	private String password;

	/**
	 * Parameterized Constructor
	 * 
	 * @param username
	 * @param age
	 * @param email
	 * @param password
	 */
	public User(String username, int age, String email, String password) {
		this.username = username;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User Details: Username=" + username + ", Age=" + age + ", Email=" + email;
	}

}
