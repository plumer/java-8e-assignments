// Java Programming Assignment 6.5
// Eliminate duplicate elements in an array
//   and print them in ascending order
// Written by 121220130

import java.util.Scanner;

public class Unique {
	public static void main( String[] args ) {
		Scanner input = new Scanner( System.in );
		int array[] = new int[10];
		System.out.print("Enter 10 integers: ");
		for (int i = 0; i < 10; ++i) {
			array[i] = input.nextInt();
		}
		int uniqueArray[] = new int[10];
		int uIndex = 0;
		for (int number : array) {
			boolean hit = false;	// whether number already exists in uniqueArray
			for(int i = 0; i < uIndex; ++i) {
				if (number == uniqueArray[i]) // hit
					hit = true;
			}
			if (!hit) {
				uniqueArray[uIndex++] = number;
			}
		}
		System.out.print("The distinct numbers are:");
		for (int i = 0; i < uIndex; ++i) {
			System.out.printf(" %d", uniqueArray[i]);
		}
		System.out.print("\n");
	}
}
