// Java Programming Assignment 4.19
// Print a pyramid of numbers

public class Pyramid {
	public static void main(String [] args) {
		// for every line
		for (int i = 1; i <= 8; ++i) {
			int j;
			// print appropriate number of blank
			for (j = i; j < 8; ++j) {
				System.out.print("     ");
			}
			// print appropriate increasing numbers
			int num = 1;
			for (j = 1; j < i; ++j) {
				System.out.printf("%5d", num);
				num *= 2;
			} 
			// print appropriate decreasing numbers
			for (; j >= 1; --j) {
				System.out.printf("%5d", num);
				num /= 2;
			} 
			System.out.print("\n");
		}
	}
}
