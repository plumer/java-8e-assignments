// Java Programming Assignment
// Solve eight queen problem
// Written by 121220130

public class EightQueen {
	private static boolean [] horizontal = new boolean[8];
	private static boolean [] vertical = new boolean[8];
	private static boolean [] mainDiag = new boolean[15];
	private static boolean [] subDiag = new boolean[15];
	private static boolean [][] chessBoard = new boolean[8][8];
	private static boolean found;
    public static void main(String[] args) {
		found = false;
		putQueen(0);
	}
	private static void putQueen(int row) {
		for (int col = 0; col < 8; ++col) {
			if (safe(row, col)) {
				occupy(row, col);
				if (row == 7) {
					found = true;
					printBoard();
				} else {
					putQueen(row+1);
					if (found)
						return;
				}
				deoccupy(row, col);
			}
		}
	}
	private static boolean safe(int row, int col) {
		return !(horizontal[row] ||
				vertical[col] ||
				mainDiag[row+col] ||
				subDiag[row+7-col]);
	}
	private static void occupy(int row, int col) {
		chessBoard[row][col] = true;
		horizontal[row] = true;
		vertical[col] = true;
		mainDiag[row+col] = true;
		subDiag[row+7-col] = true;
	}
	private static void deoccupy(int row, int col) {
		chessBoard[row][col] = false;
		horizontal[row] = false;
		vertical[col] = false;
		mainDiag[row+col] = false;
		subDiag[row+7-col] = false;
	}
	private static void printBoard() {
		for (int i=0; i < 8; i++) {
			System.out.print("|");
			for (int j = 0; j < 8; j++) {
				System.out.printf("%c|", (chessBoard[i][j] ? 'Q' : '_'));
			}
			System.out.print("\n");
		}
		System.out.print("\n\n");
	}
}
