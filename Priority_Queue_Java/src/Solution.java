import java.io.*;
import java.util.PriorityQueue;


public class Solution {

    public static void priority_queue(int [] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int x : nums) {
            pq.offer(x);
        }

        System.out.println("PQ : "+pq);

        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, pq);


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

        System.out.println("Search Index: " +  priority_queue(nums));



    }
}
