// Java Programming Assignment 7.13
// Test LocateLargest Class and its function
// Written by 121220130

import java.util.Scanner;

public class TestLocateLargest {
	public static void main(String[] args) {
		Scanner input = new Scanner( System.in );
		System.out.print("Enter the number of rows and columns of the array: ");
		int row = input.nextInt();
		int col = input.nextInt();
        double [][] array = new double[row][col];
        System.out.print("Enter the array:\n");
        for (int i = 0; i < row*col; ++i) {
            array[i/col][i%col] = input.nextDouble();
        }
        int [] location = LocateLargest.locateLargest(array);
        System.out.printf("The location of the largest element is at (%d, %d)\n", location[0], location[1]);
	}
}
