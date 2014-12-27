// Java Programming Assignment
// Test BubbleSort class and its function
// Written by 121220130

import java.util.Scanner;

public class TestBubbleSort {
    public static void main(String[] args) {
		int [] array = new int[10];
		Scanner input = new Scanner (System.in);
		for (int i=0; i<array.length; i++) {
			array[i] = input.nextInt();
		}
		BubbleSort.sort(array);
		for (int number : array)  {
			System.out.printf("%d ", number);
		}
		System.out.print("\n");
	}
}
