// Java Programming Assignment 6-21
// Implement slot machine
// Written by 121220130

import java.util.Scanner;

public class Slotter {
	public static void main (String[] args) {
		Scanner input = new Scanner( System.in );
		System.out.print("Enter the number of balls to drop: ");
		int balls = input.nextInt();
		System.out.print("Enter the number of slots in the bean machine: ");
		int numberOfSlots = input.nextInt();

		System.out.print("\n\n");

		int [] slots = new int[numberOfSlots];
		int right, slotIndex;
		for (int i = 0; i < balls; i++) {
			slotIndex = 0;
			for (int j = 1; j < numberOfSlots ; j++) {
				double res = Math.random() * 2;
	//			System.out.printf("%f", res);
				right = (int)res;
				slotIndex += right;
				System.out.printf("%c", (right == 1) ? 'R' : 'L');
			} 
			System.out.print("\t");
			slots[slotIndex]++;
		}
		System.out.print("\n\n");
		int max = 0;
		for (int i = 0; i < numberOfSlots; ++i)
			if (slots[i] > max)
				max = slots[i];

		for (; max > 0; max--) {
			for (int i = 0; i < numberOfSlots; ++i) {
				if (slots[i] >= max) {
					System.out.print("O");
				} else
					System.out.print(" ");

			} 
			System.out.print("\n");
		} 
		for (int i =0; i < numberOfSlots; ++i)
			System.out.printf("%d ", slots[i]);
	}
}


