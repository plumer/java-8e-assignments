// Java Programming Assignment 7.4
// Sort employees based on their total week working hours
// Written by 121220130

public class WorkingHours {
	public static void main (String[] args) {
		int [][] employee = {
			{2,4,3,4,5,8,8},
			{7,3,4,3,3,4,4},
			{3,3,4,3,3,2,2},
			{9,3,4,7,3,4,1},
			{3,5,4,3,6,3,8},
			{3,4,4,6,3,4,4},
			{3,7,4,8,3,8,4},
			{6,3,5,9,2,7,9}
		};

		int [][] result = new int[employee.length][2];
		for (int e = 0; e < employee.length; ++e) {
			result[e][0] = e;
			for (int i=0; i<employee[e].length; i++) {
				result[e][1] += employee[e][i];
			}
		}
		
		int[] tempArray;
		for (int i = 0; i < result.length; ++i) {
			for (int j = 0; j < result.length-i-1; ++j) {
				if (result[j][1] < result[j+1][1]) {
					tempArray = result[j];
					result[j] = result[j+1];
					result[j+1] = tempArray;
				}
			} 
		} 
		System.out.print("Employee #  Total Working Hours\n");
		for (int i = 0; i < result.length; ++i) {
			System.out.printf("%10d %20d\n", result[i][0], result[i][1]);
		}
	}
}
