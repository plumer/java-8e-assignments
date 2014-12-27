// Java Programming Assignment 5.16
// Test of class DaysInYear, print days in year 2000-2010
// Written by 121220130

public class TestDaysInYear {
	public static void main( String [] args ) {
		for (int i = 2000; i <= 2010; ++i) {
			System.out.print(DaysInYear.numberOfDaysInAYear(i)+"\n");
		}
	}
}
