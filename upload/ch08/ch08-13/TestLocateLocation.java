import java.util.Scanner;

public class TestLocateLocation {
	public static void main( String[] args) {
		Scanner input = new Scanner( System.in );
		System.out.print("Enter the number of rows and columns of the array: ");
		int row = input.nextInt();
		int col = input.nextInt();
		double [][] array = new double[row][col];
		System.out.print("Enter the array: \n");
		for (int r = 0; r < row; ++r) 
			for (int c = 0; c < col; ++c)
				array[r][c] = input.nextDouble();
		Location max = LocateLocation.locateLargest(array);
		System.out.printf("The location of the largest element is %f at (%d, %d)", 
			max.maxValue, max.row, max.col);
	}
}
