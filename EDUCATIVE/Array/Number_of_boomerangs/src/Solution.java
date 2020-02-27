import java.io.*;
import java.util.HashMap;
import java.util.*;

public class Solution {

    public static int getDistance(int [] a, int [] b) {
        int dx = a[0] - b[0];
        int dy = b[1] - b[1];

        return dx * dx + dy * dy;
    }
    public static int numberOfBoomerangs(int[][] points) {
       int res = 0;

       HashMap<Integer, Integer > map = new HashMap<>();
       for(int i=0; i < points.length; i++) {
           for(int j=0; j < points[0].length; j++) {
               if(i==j)
                   continue;


               int d = getDistance(points[i] , points[j]);
               map.put(d, map.getOrDefault(d, 0) + 1);
           }

           for (Map.Entry<Integer, Integer> entry : map.entrySet())
               System.out.println("Key = " + entry.getKey() +
                       ", Value = " + entry.getValue());

            for (int val : map.values()) {
                res += val * (val -1);
            }
       }

       return res;
    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter number of elements in Arrays");
        int n = sc.nextInt();
        int [][] points = new int[n][2];

        for (int i=0; i < n; i++) {
            for(int j=0; j < 2; j++) {
                points[i][j] = sc.nextInt();
            }
        }

        int result = numberOfBoomerangs(points);

        System.out.println(result);

    }
}
