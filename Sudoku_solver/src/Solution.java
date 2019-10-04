import java.io.*;


public class Solution {

    public static void solveSudoku(char [][] board) {

        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    public static boolean solve(char [][] board) {
        for(int i=0 ; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for(char c='1'; c < '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            // if that leads to a solution
                            if (solve(board)) {
                                return true;
                            } else {
                                // backtrack
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;

                }
            }
        }
        return true;
    }

    public static boolean isValid(char [][] board, int row, int col, char c) {
        for(int i=0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }

            // check 3*3 matrix

            if (board[3 * (row/3) + i/3] [3 * (col/3) + i%3] == '.'
                && board[3 * (row/3) + i/3] [3 * (col/3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter number of elements in Arrays");
        int n = sc.nextInt();
        char [][] sudoku = new char[n][n];

        for (int i=0; i < n; i++) {
            for(int j=0; j <n; j++) {
                sudoku[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println("Solution of the Sudoku");

        solveSudoku(sudoku);

        for (int i=0; i < n; i++) {
            for(int j=0; j <n; j++) {
                System.out.print(sudoku[i][j]+' ');
            }
            System.out.println();
        }
    }
}
