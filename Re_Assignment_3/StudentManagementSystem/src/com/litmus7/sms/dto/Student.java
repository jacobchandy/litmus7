package com.litmus7.sms.dto;

import java.util.Scanner;

/**
 * Represents a student with name, roll number, and subject marks with
 * functionality to input student details, calculate total and average,
 * determine grade and print a report card.
 */
public class Student {
	private String name; // name of the student
	private int rollNumber; // roll number of student
	private int[] marks = new int[5]; // marks for each subject

	/**
	 * Enum to represent grades
	 */
	private enum Grade {
		A, B, C, D, F;
	}

	/**
	 * Read student details using scanner
	 */
	public void inputDetails(Scanner scanner) {
		scanner.nextLine();
		System.out.print("Enter the student name: ");
		name = scanner.nextLine();

		System.out.print("Enter the roll number: ");
		rollNumber = scanner.nextInt();

		System.out.println("Enter marks in 5 subjects:");
		for (int i = 0; i < 5; i++) {
			System.out.print("Subject " + (i + 1) + ":");
			marks[i] = scanner.nextInt();
		}
	}

	/**
	 * Calculate the total marks from each subject
	 * 
	 * @return total marks as integer
	 */
	private int calculateTotal() {
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += marks[i];
		}
		return sum;
	}

	/**
	 * Calculate the average marks
	 * 
	 * @return average marks as double type
	 */
	private double calculateAverage() {
		return calculateTotal() / 5;
	}

	/**
	 * From average marks calculate determine the grade
	 * 
	 * @return Grade enum data type
	 */
	private Grade getGrade() {
		double average = calculateAverage();
		if (average >= 90)
			return Grade.A;
		else if (average >= 75)
			return Grade.B;
		else if (average >= 60)
			return Grade.C;
		else if (average >= 50)
			return Grade.D;
		else
			return Grade.F;
	}

	/**
	 * get the description of the grade
	 * 
	 * @param grade enum type
	 * @return description of string type
	 */
	private String getDescription(Grade grade) {
		switch (grade) {
		case A:
			return "Excellent";
		case B:
			return "Good";
		case C:
			return "Average";
		case D:
			return "Pass";
		case F:
			return "Fail";
		}
		return null;
	}

	/**
	 * Print the report card for the student
	 */
	public void printReportCard() {
		System.out.println("--- Report Card ---");
		System.out.println("Name: " + name);
		System.out.println("Roll number: " + rollNumber);
		System.out.println("Total marks: " + calculateTotal());
		System.out.println("Average marks: " + calculateAverage());
		System.out.println("Grade: " + getGrade() + "(" + getDescription(getGrade()) + ")");
	}
}
