package com.litmus7.sms;

import java.util.Scanner;

import com.litmus7.sms.dto.*;

/**
 * Student Application to input student details and print report card
 */

public class StudentApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of students: ");
		int n = scanner.nextInt();

		Student[] students = new Student[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Student " + (i + 1));
			students[i] = new Student();
			students[i].inputDetails(scanner);
		}

		for (int i = 0; i < n; i++) {
			students[i].printReportCard();
		}

		scanner.close();
	}
}
