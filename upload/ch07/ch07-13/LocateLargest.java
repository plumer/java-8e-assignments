// Java Programmming Assignment 7.13
// Locate the largest element in a 2-dimensional array
// Written by 121220130

public class LocateLargest {
	public static int[] locateLargest(double [][] a) {
		int maxRow = 0, maxCol = 0;
		for (int row = 0; row < a.length; ++row) {
			for (int col = 0; col < a[row].length; ++col) {
				if (a[row][col] > a[maxRow][maxCol]) {
					maxRow = row;
					maxCol = col;
				}
			}
		}
		int [] result = {maxRow, maxCol};
		return result;
	}
}
