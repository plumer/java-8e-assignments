// Java Programming Assignment 2.6
// Compute the sum of all digits of a given number
// Written by 121220130 



import java.util.Scanner;

public class DigitSum {
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		// get number from input
		System.out.print("Enter a number between 0 and 1000: ");
		int number;
		number = input.nextInt();
		// get absolute value of number
		number = (number >= 0) ? number : -number; 
		// calculate sum
		int sum = 0;
		while (number>0) {
			sum += number % 10;
			number /= 10;
		}
		// print result
		System.out.printf("The sum of the digits is %d\n", sum);
	}
}
