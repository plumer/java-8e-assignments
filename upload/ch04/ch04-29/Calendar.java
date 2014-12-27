// Java Programming Assignments 4.29
// Print the calendar of 12 months of a given year
// Written by 121220130

import java.util.Scanner;

public class Calendar {
	public static void main( String [] args) {
		Scanner input = new Scanner( System.in );
		int year = input.nextInt();
		int day = input.nextInt();
		boolean leap = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);

		int [] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (leap)
			days[1] += 1;
		String [] monthString = {
			"January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December"
		};
		String [] dayString = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		day %= 7;
		for (int month = 1; month <= 12; ++month) {
			System.out.printf("  %-12s %d\n", monthString[month-1], year);
			System.out.print("  ---------------------------------\n");
			for (int i = 0; i < 7; ++i)
				System.out.printf("%5s", dayString[i]);
			System.out.print("\n");
			for (int i = 0; i < day; ++i)
				System.out.print("     ");
			for (int i = 0; i < days[month-1]; ++i) {
				System.out.printf("%5d", i+1);
				if (day == 6) {
					day = 0;
					System.out.print("\n");
				} else
					day++;
			}
			System.out.print("\n\n");
		} 
	}
}
