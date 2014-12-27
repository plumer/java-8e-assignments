// Java Programming Assignment 7.9
// Implement tic-tac-toe game
// Written by 121220130


import java.util.Scanner;

public class TicTacToe {
	private static char [][] board = {
		{' ', ' ', ' '},
		{' ', ' ', ' '},
		{' ', ' ', ' '}
	};
	public static void main(String[] args) {
		boolean end = false;
		char winner = ' ';
		char turn = 'X';
		Scanner input = new Scanner(System.in);
		int row, col, moves=0;
		while (!end && moves < 9) {
			do {
				do {
					System.out.printf("Enter a row (1-3) for player %c: ", turn);
					row = input.nextInt();
				} while (row < 1 || row > 3);
				do {
					System.out.printf("Enter a column (1-3) for player %c: ", turn);
					col = input.nextInt();
				} while (row < 1 || row > 3);
				if (board[row-1][col-1] != ' ') {
					System.out.printf("Place (%d, %d) has been occupied.\n", row, col);
				}
			} while (board[row-1][col-1] != ' ');
			board[row-1][col-1] = turn;
			moves++;
			if (board[row-1][0] == board[row-1][1] && board[row-1][1] == board[row-1][2] ||
				board[0][col-1] == board[1][col-1] && board[1][col-1] == board[2][col-1] ||
				board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] == turn||
				board[0][2] == board[1][1] && board[1][1] == board[2][2] && board[1][1] == turn
				) {
				end = true;
				winner = turn;
			}
			if (!end) {
				turn = (turn == 'X' ? 'O' : 'X');
			}
			printBoard();
		}
		if (end)
			System.out.printf("%c player won\n", winner);
		else
			System.out.print("tie\n");
	}
	public static void printBoard() {
		System.out.print("-------------\n");
		System.out.printf("| %c | %c | %c |\n", board[0][0], board[0][1], board[0][2]);
		System.out.print("-------------\n");
		System.out.printf("| %c | %c | %c |\n", board[1][0], board[1][1], board[1][2]);
		System.out.print("-------------\n");
		System.out.printf("| %c | %c | %c |\n", board[2][0], board[2][1], board[2][2]);
		System.out.print("-------------\n");

	}
}
