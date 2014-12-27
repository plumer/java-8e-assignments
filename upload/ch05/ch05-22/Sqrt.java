// Java Programming Assignment 5.22
// Compute the square root of a given value, using Newton's algorithm
// Written by 121220130

import java.util.Scanner;

public class Sqrt {
	public static double sqrt(double num) {
		if (num == 0) return 0;
		double lastGuess = num / 4.0;
		double nextGuess = (lastGuess + num/lastGuess) / 2;
		while (nextGuess - lastGuess < -0.0001 || nextGuess - lastGuess > 0.0001) {
			lastGuess = nextGuess;
			nextGuess = (lastGuess + num/lastGuess) / 2;
		}
		return nextGuess;
	}
	public static void main( String[] args ) {
		Scanner input = new Scanner( System.in );
		System.out.print("Enter a number: ");
		double number = input.nextDouble();
		if (number >= 0)
			System.out.printf("sqrt(%f) = %f\n", number, sqrt(number));
		else
			System.out.printf("sqrt(%f) = %fi\n", number, sqrt(-number));
	} 
}
