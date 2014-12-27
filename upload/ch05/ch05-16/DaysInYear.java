// Java Programming Assignment 5.16
// Return number of days of a given year
// Written by 121220130

public class DaysInYear {
	public static int numberOfDaysInAYear(int year) {
		boolean leap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
		return 365 + ( (leap) ? 1 : 0 );
	}
}
