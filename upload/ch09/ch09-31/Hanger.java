// Java Programming Assignment 9-31
// Implement THE HANGED MAN game
// Written by 121220130

import java.util.Scanner;

public class Hanger {
	static Scanner input;
	public static void main ( String [] args ) {
		String [] words = {
			"programming", "data", "structure", "algorithm", "database", "network", "bazinga", "linux",
			"graphics"
		};
		
		input = new Scanner( System.in );


		for (int i = 0; i < words.length; ++i) {
			play(words[i]);
			if (i < words.length-1) {
				System.out.println("Do you want to guess for another word[Y/n]? ");
				String answer = input.nextLine();
				if (answer.charAt(0) == 'n'|| answer.charAt(0) == 'N') 
					break;
			} else {
				System.out.println("You have played with all the words. Game end.");
			}
		}
	}

	public static void play( String word ) {
		char [] show = new char[ word.length() ];
		for (int i = 0; i < show.length; ++i) 
			show[i] = '*';

		boolean complete = false;
		boolean hit;
		boolean rehit;
		int wrongCount = 0;
		while ( !complete ) {
			hit = false;
			rehit = false;
			System.out.print("(Guess) Enter a letter in word ");
			System.out.print( new String(show) + " > ");
			char guess = (char) (input.nextLine().charAt(0) | 0x20);

			// look for the character guess in word
			int position = word.indexOf(guess);
			complete = true;
			for (int i = 0; i < show.length; ++i) {
				if (guess == word.charAt(i)) {
					if (guess == show[i]) {
						rehit = true;
					}
					show[i] = guess;
					hit = true;
				} else if (show[i] == '*' ) {
					complete = false;
				}
			}

			if (!hit) wrongCount++;
			if (rehit) System.out.println("   character " + guess + " has been guessed");
		}
		System.out.println("The word is '" + new String(show) + "'. You missed " + wrongCount + (wrongCount == 1 ?" time":" timesi\n"));
	}
}
