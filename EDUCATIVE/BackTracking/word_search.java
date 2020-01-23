class Solution {
    public static boolean [][] visited;
    public boolean search(char [][] board, String word, int i, int j,int pos) {

        if(pos==word.length()) {
            return true;
        } 
        // not found
        if( i < 0 || j < 0 || i >= board.length || j >= board[0].length
            || word.charAt(pos) != board[i][j] || visited[i][j] ) {
            return false;
        }

        visited[i][j] = true;

        if(search(board, word, i+1, j, pos + 1)
          || search(board, word, i - 1, j, pos + 1)
          || search(board, word, i, j+1, pos + 1)
          || search(board, word, i, j-1, pos + 1)) {
              return true;
          }


          visited[i][j] = false;
          return false;
       


    }
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        visited = new boolean[m][n];

        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[i].length; j++){
                if (word.charAt(0) == board[i][j] && search(board, word, i, j,0)) {
                    return true;
                }
            }
        }
        return false;
    }
}