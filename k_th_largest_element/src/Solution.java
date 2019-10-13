import java.io.*;
import java.util.*;
import java.util.PriorityQueue;


public class Solution {

    public static int find_kth_largest(int [] nums, int k) {
       if (nums == null || nums.length == 0) {
           return -1;
       }

        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, Collections.reverseOrder());

       for( int num : nums) {
           pq.offer(num);
       }

       while( k-1>0) {
           pq.remove();
           k--;
       }
       return pq.peek();
    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter number of elements in Arrays");
        int n = sc.nextInt();
        int [] nums = new int[n];

        for (int i=0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter the target element");
        int k = sc.nextInt();

        System.out.println("Search Index: " +  find_kth_largest(nums, k));



    }
}
