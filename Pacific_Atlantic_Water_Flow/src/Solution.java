import java.io.*;
import java.util.*;


public class Solution {
    /*
    If we think the problem the other way, if a position (i,j) can reach both Pacific and Atlantic,\
     it mean there must be Pacific position (pi, pj) and Atlantic (ai, ai) which connect to (i, j).
     In another word, (i, j) must be in the DFS/BFS search path beginning from (pi, pj) and (ai, aj).
     So, if we can find all the node which can be reached from Pacific edge (row or column is 0)
     and Atlantic (row or column is maximum), these node are the position where water can flow to both the Pacific and Atlantic ocean.
     */

    public static int [][] dirs = new int [][] { { 1,0} , {0,1}, {-1,0}, {0, -1}};

    private static void bfs(int [][] matrix, Queue<int[]> queue, boolean [][] visited) {
        int n = matrix.length;
        int m = matrix[0].length;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            //int x=0, y=0;
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];


                if (x < 0
                        || x >= n
                        || y < 0
                        || y >= m
                        || visited[x][y]
                        || matrix[x][y] < matrix[cur[0]][cur[1]]) {
                    continue;
                }

                visited[x][y] = true;
                queue.offer(new int[]{x, y});

            }
        }
    }

    public static List<int[]> pacific_atlantic(int [][] matrix) {

        List<int[]> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;

        int n = matrix.length;
        int m = matrix[0].length; // column length
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        boolean [][] pacific = new boolean[n][m];
        boolean [][] atlantic = new boolean[n][m];

        // vertical border
        for(int i=0; i<n; i++) {
            pQueue.offer(new int [] { i, 0});
            aQueue.offer(new int [] { i, m-1});
            pacific[i][0] = true;
            atlantic[i][m-1] = true;

        }

        for(int i=0; i < m; i++) {
            pQueue.offer(new int [] { 0, i});
            aQueue.offer(new int [] {n-1, i});
            pacific[0][i] = true;
            atlantic[n-1][i] = true;
        }

        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);

        for(int i=0 ; i < n; i++) {
            for(int j=0; j <m; j++) {
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(new int [] {i,j});
                }
            }
        }

        return result;



    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter number of rows in Arrays");
        int n = sc.nextInt();
        System.out.println("Enter number of columns in Arrays");
        int m = sc.nextInt();

        int [][] matrix = new int[n][m];

        for (int i=0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }

        List<int[]> result = pacific_atlantic(matrix);
        //System.out.print(result.);

        for(int i =0; i < result.size(); i++) {
            System.out.print(Arrays.toString(result.get(i)) + " ");
        }

    }
}
