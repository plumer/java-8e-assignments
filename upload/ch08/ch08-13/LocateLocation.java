public class LocateLocation {
	public static Location locateLargest(double [][] a) {
		int maxRow = 0, maxCol = 0;
        for (int r = 0; r < a.length; ++r) {
            for (int c = 0; c < a[r].length; ++c) {
                if (a[r][c] > a[maxRow][maxCol]) {
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
		Location res = new Location(maxRow, maxCol, a[maxRow][maxCol]);
        return res;
    }
}
