import java.io.*;


public class Solution {

    public static boolean find_element(int [][] nums, int target) {
        int row = 0, col = nums[0].length - 1;

        while( row < col && col > 0) {
           if (nums[row][col] == target)
               return true;

           else if (nums[row][col] > target)
               col--;
           else
               row++;
       }
        return false;
    }

    public static void main(String[] args) {
        // write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter number of elements in Arrays");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int [][] nums = new int[m][n];

        for (int i=0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }


        System.out.println("Enter the target element");
        int target = sc.nextInt();

        System.out.println("Search Index: " +  find_element(nums, target));

    }
}
