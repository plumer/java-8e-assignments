import java.util.Scanner;
/**
 * Created by vocryan on 10/29/14.
 */
public class BlurSearch {
	private static int [][] cost = new int[64][64];
	public static int editDistance(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if (len1 == 0) return len2;
		if (len2 == 0) return len1;
		if (len1 >= 63 || len2 >= 63) {
			System.out.println("too long = =");
			return 1000;
		}
		for (int i = 1; i <= len1; ++i)
			cost[0][i] = i;
		for (int i = 1; i <= len2; ++i)
			cost[i][0] = i;
		int currCost = 0;
		for (int i = 1; i <= len1; ++i) {
			for (int j = 1; j <= len2; ++j) {
				currCost = (s1.charAt(i-1) == s2.charAt(j-1) ? 0 : 1);
				cost[i][j] = min3(cost[i][j - 1] + 1, cost[i - 1][j] + 1, cost[i-1][j-1] + currCost);
			}
		}
		return cost[len1][len2];
	}
	public static int min3(int a, int b, int c) {
		if (a < b) {
			if (a < c)
				return a;
			else
				return c;
		} else {
			if (b < c)
				return b;
			else
				return c;
		}
	}
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(editDistance(input.next(), input.next()));
	}

}
