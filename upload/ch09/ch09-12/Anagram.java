import java.util.Scanner;

public class Anagram {
	public static void main(String [] args) {
		Scanner input = new Scanner( System.in );
		System.out.printf("Enter two words and separate them with space: \n");
		String s1 = input.next();
		String s2 = input.next();
		int [] stat1 = statistics(s1);
		int [] stat2 = statistics(s2);
		boolean equal = true;
		for (int i = 0; i < 26; ++i) {
			if (stat1[i] != stat2[i]) {
				equal = false;
				System.out.print("not ");
				break;
			}
		}
		System.out.print("anagram\n");
	}
	
	public static int[] statistics( String word ) {
		int [] counts = new int[26];
		for (int i = 0; i < word.length(); ++i) {
			counts[ (word.charAt(i) | 0x20) - 'a']++;
		}
		return counts;
	}
}
