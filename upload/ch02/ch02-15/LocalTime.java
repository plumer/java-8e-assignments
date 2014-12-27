// Java Programming Assignment 2.15
// Display current time for a given timezone in the form of offset
// Written by 121220130


import java.util.Scanner;

public class LocalTime {
	public static void main (String [] args) {
		System.out.print("Enter the time zone offset to GMT: ");
		// get timezone offset
		Scanner input = new Scanner( System.in );
		int offset = input.nextInt();
		// compute seconds, minutes and hours
		long totalMilliseconds = System.currentTimeMillis();
		long totalSeconds = totalMilliseconds / 1000;
		long currentSecond = totalSeconds % 60;
		long totalMinutes = totalSeconds / 60;
		long currentMinute = totalMinutes % 60;
		long totalHours = totalMinutes / 60;
		long currentHour = totalHours % 24;
		// display the result
		currentHour = (currentHour + 24 + offset) % 24;
		System.out.printf("The current time is %2d:%2d:%2d\n", currentHour, currentMinute, currentSecond);
	}
}
