// Java Programming Assignment 3.11
// Print the number of days in a given year and month
// Written by 121220130

import java.util.Scanner;

public class DaysOfMonth {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// get year and month from user input
		System.out.print("Enter year and month: ");
		int year = input.nextInt();
		int month = input.nextInt();

		boolean leap = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
		int result = 0;
		if (month <= 0 || month >= 13) {
			System.out.printf("Month invalid: %d\n", month);
			return;
		} else if (month == 2) {
			result = 28 + (leap ? 1 : 0);
		} else if (month == 4 || month == 6 || month == 9 || month == 11) 
			result = 30;
		else
			result = 31;
		String [] monthString = {"January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December"};
		System.out.printf("%s %d has %d days\n", monthString[month-1], year, result);
	}
}
