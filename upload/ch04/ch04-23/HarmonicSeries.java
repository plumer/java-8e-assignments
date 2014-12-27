// Java Programming Assignments 4.23
// Compute the harmonic series of 50000
// 	 in both obverse and reverse order

public class HarmonicSeries {
	public static void main (String [] args) {
		float sum = 0.0f;
		for (int i = 50000; i >= 1; i--)
			sum += 1.0f/i;
		System.out.printf("Reversed addition: %13.10f\n", sum);
		sum = 0.0f;
		for (int i = 1; i <= 50000; i++)
			sum += 1.0f/i;
		System.out.printf("Obverse addition: %13.10f\n", sum);
	}
}
