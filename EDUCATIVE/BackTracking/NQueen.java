import java.util.*;

class Solution {
    /*
    The idea is to place queens one by one in different columns, starting from the leftmost column. 
    When we place a queen in a column, we check for clashes with already placed queens. In the current 
    column, if we find a row for which there is no clash, we mark this row and column as part of the solution.
    If we do not find such a row due to clashes then we backtrack and return false.

    1) Start in the leftmost column
    2) If all queens are placed
    return true
    3) Try all rows in the current column. 
    Do following for every tried row.
    a) If the queen can be placed safely in this row 
       then mark this [row, column] as part of the 
       solution and recursively check if placing
       queen here leads to a solution.
    b) If placing the queen in [row, column] leads to
       a solution then return true.
    c) If placing queen doesn't lead to a solution then
       unmark this [row, column] (Backtrack) and go to 
       step (a) to try other rows.
    3) If all rows have been tried and nothing worked,
        return false to trigger backtracking.
   */

   // to understand is valid
    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];

        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;

    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }


        for(int i=0; i < board.length; i++ ){
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] ='.';
            }
        }
    }

    /*
        if Queeen in (1,2)
        positions that are under attack are                             1+2 = 3 (row + col)
        Row(same row value)     Col(same col)     Dia (row - col)    left Dia
        (1,0)                   (0,2)             (0,1)                (3,0)= 3
        (1,1)                   (2,2)             (2,3)                 (2,1)
        (1,3)                   (3,2)                                   (0,3)
    */
    private boolean validate(char [][] board, int row, int col) {
        for(int i=0; i < board.length; i++) { // i for row
            for(int j=0; j <col; j++) { // j for col
                //clashes with already placed queen in the same place 

                //row -col = i -j means right diagonal 
                //row + col = i + j left diagonal
                if(board[i][j] == 'Q' && (row - col  == i - j || row + col == i + j || row == i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<String> construct(char [][] board){
        List<String> res = new LinkedList<>();

        for(int i=0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}