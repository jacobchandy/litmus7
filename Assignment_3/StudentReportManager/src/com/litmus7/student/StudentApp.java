package com.litmus7.student;

import com.litmus7.student.dto.*;
import java.util.Scanner;
public class StudentApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of students: ");
		int n=scanner.nextInt();
		Student[] students = new Student[n];
		for(int i=0; i<n; i++) {
			System.out.println("Student "+(i+1));
			students[i] = new Student();
			students[i].inputDetails();
		}
		for(int i=0; i<n; i++) {
			students[i].printReportCard();
		}
		scanner.close();
	}		
}
