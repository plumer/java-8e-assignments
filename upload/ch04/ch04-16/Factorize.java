// Java Programming Assignment 4.16
// Factorize a given number into a non-decreasing sequence of prime numbers
// Written by 121220130

import java.util.Scanner;
import java.lang.Math;

public class Factorize {
	public static void main(String [] args) {
		// get the number from user input
		Scanner input = new Scanner( System.in );
		System.out.print("Enter the number to factorize: ");
		long number = input.nextLong();
		
		// upperBound is the upper bound for all prime factors for the given number
		int upperBound = (int)(Math.sqrt(number));
		boolean [] primes = new boolean[upperBound+1];
		for (int i = 2; i <= upperBound; ++i)
			primes[i] = true; 	// assume all numbers are primes
		primes[0] = primes[1] = false; 	// except 0 and 1
		int currentPrime = 2;
		while (number > 1) {
			// filter all numbers in the primes[] array
			for (int filter = currentPrime * 2; filter <= upperBound; filter += currentPrime)
				primes[filter] = false;
			// divide the given number until it is undividable by the current prime
			while (number % currentPrime == 0) {
				System.out.printf("%d ", currentPrime);
				number /= currentPrime;
			}
			// get the next prime
			do {
				currentPrime++;
			} while (currentPrime <= upperBound && !primes[currentPrime]);
		}
		System.out.print("\n");
	}
}
