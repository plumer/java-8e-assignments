// Java Programming Assignment 7.20
// Implement four-chess game
// Written by 121220130

import java.util.Scanner;

public class FourGame {
    private static char [][] board = new char[6][7];
    private static int [] sp = new int[7]; // stack pointers
    public static void main(String[] args) {
        // initialize board: fill with space
        for (int i = 0; i < 42; ++i)
            board[i/7][i%7] = ' ';

        Scanner input = new Scanner ( System.in );
        boolean end = false;
        char turn = 'R';
        int position = 0; // which column user chooses to drop
        printBoard();

        for (int moves = 0; moves < 42; ++moves) {
            do {
                do {
                System.out.printf("Drop a %s disk at column (0-6): ",
                    (turn == 'R' ? "red" : "yellow"));
                    position = input.nextInt();
                } while (position < 0 || position > 6);
                if (sp[position] >= 6)
                    System.out.printf("Column #%d full\n", position);
            } while (sp[position] >= 6);
            board[5-sp[position]][position] = turn; // drop a disk

            //System.out.print("Before checking\n");
            if (match(5-sp[position], position)) {
                end = true;
                printBoard();
                break;
            }

            //System.out.print("This should print\n");
            sp[position]++;
            turn = (turn == 'R' ? 'Y' : 'R');
            printBoard();
        }
        if (end)
            System.out.printf("%s wins\n", (turn == 'R' ? "red" : "yellow"));
        else
            System.out.print("tie\n");
    }

    private static void printBoard() {
        for (int row = 0; row < 6; ++row) {
            for (int col = 0; col < 7; ++col) {
                System.out.printf("|%c", board[row][col]);
            }
            System.out.print("|\n");
        }
        System.out.print("---------------\n");
    }

    // check if the last move makes the turn player a winner
    private static boolean match(int row, int col) {
        System.out.printf("(%d, %d)\n", row, col);
        int count = 1;
        for (int r = row; r <6 ; ++r) {     // row check
            while (r < 5 && board[r][col] == board[r+1][col] && board[r][col] != ' ') {
                count++;
                r++;
            }
            if (count <= 3)
                count = 1;
            else
                return true;
        }
        count = 1;
        for (int i = 0; i < 7; ++i) {       // column check
            while (i < 6 && board[row][i] == board[row][i+1] && board[row][i] != ' ') {
                count++;
                i++;
            }
            if (count <= 3)
                count = 1;
            else
                return true;
        }
        count = 1;
        if (row >= col && row - col < 3) {  // main diagonal check
            // col never overflows
            for (int r = row-col, c = 0; r < 6 && c < 7; ++r, ++c) {
                while (r < 5 && board[r][c] == board[r+1][c+1] && board[r][c] != ' ') {
                    count++;
                    r++; c++;
                }
                if (count <= 3)
                    count = 1;
                else
                    return true;
            }
        } else if (row < col && col - row < 3) {
            // row never overflows
            for (int r = 0, c = col-row; r < 6 && c < 7; ++r, ++c) {
                while (c < 6 && board[r][c] == board[r+1][c+1] && board[r][c] != ' ') {
                    count++;
                    r++;
                    c++;
                }
                if (count <= 3)
                    count = 1;
                else
                    return true;
            }
        }
        count = 1;
        int sum = row + col;
        if (sum > 2 && sum < 9) {           // sub diagonal check
            for (int r = (sum <= 5 ? sum : 5),
                     c = (sum <= 5 ? 0 : sum - 5);
                 r < 6 && c < 7;
                 ++r, ++c) {
                while (r > 0 && c < 6 && board[r][c] == board[r-1][c+1] && board[r][c] != ' ') {
                    count++;
                    r--; c++;
                }
                if (count <= 3) count = 1;
                else return true;
            }
        }
        return false;
    }
}
