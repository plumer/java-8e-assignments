// Java Programming Assignment 5.23
// Generate 100 random CAPITAL letters and 100 random digits, then display them
// Written by 121220130

public class TestRandomCharacter {
	public static void main(String [] args) {
		for (int i = 0; i < 100; ++i) {
			System.out.print( RandomCharacter.getRandomUpperCaseLetter());
			if ((i+1) % 10 == 0) {
				System.out.print("\n");
			}
		}
		for (int i = 0; i < 100; ++i) {
			System.out.print( RandomCharacter.getRandomDigitCharacter());
			if ((i+1) % 10 == 0) {
				System.out.print("\n");
			}
		}
	}
}
