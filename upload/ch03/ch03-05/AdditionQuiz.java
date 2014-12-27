// Java Programming Assignment 3.5
// Quiz of sum of 3 numbers
// Written by 121220130



import java.util.Scanner;

public class AdditionQuiz {
	public static void main ( String [] args ) {
		// create 3 random numbers
		int number1 = (int)(System.currentTimeMillis() * 233 % 10);
		int number2 = (int)(number1 * 2333 % 10);
		int number3 = (int)(number2 * 23333 % 10);

		Scanner input = new Scanner( System.in );
		// print the question
		System.out.printf("What is %d + %d + %d ? ", number1, number2, number3);
		int answer = input.nextInt();
		// print the judgment result
		System.out.printf("%d + %d + %d = %d is %s\n", number1, number2, number3, answer, 
						(number1 + number2 + number3 == answer) ? "correct" : "incorrect");
	}
}
