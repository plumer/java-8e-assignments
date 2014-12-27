// Java Programming Assignment 5.30
// find twin prime pairs less than 1000
// Written by 121220130

public class TwinPrime {
	private static boolean prime[] = new boolean[1000];
	public static void main( String[] args ) {
		markPrime();
		for (int i = 3; i < 1000; i += 2) {
			if (prime[i] && prime[i+2])
				System.out.printf("(%d, %d)\n", i, i+2);
		}
	}       
	// mark all primes using filter algorithm
	public static void markPrime() {
		for (int i = 2; i < 1000; ++i)
			prime[i] = true;
		int j = 2;
		while (j < 1000) {
			for (int k = j * 2; k < 1000; k += j)
				prime[k] = false;
			do {
				j++;
			} while (j < 1000 && !prime[j]);
		}
	}
}
