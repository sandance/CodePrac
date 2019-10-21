import java.io.*;
import java.util.*;

//Best explaination: https://www.youtube.com/watch?v=J6o_Wz-UGvc

public class Solution {

    public static List<Integer> sliding_window(int [] nums, int k) {

        if (nums.length == 0 || nums == null)
            return null;

        Deque<Integer> deque = new ArrayDeque<>(); // deque
        List<Integer> result = new ArrayList<>();

        for(int i=0; i < nums.length; i++) {

            while(!deque.isEmpty() && deque.peek() < i - k +1) {
                deque.poll();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.peekLast();
            }

            deque.offer(i);
            if (i >= k -1) {
                result.add(nums[deque.peek()]);
            }
        }

       return result;

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

        System.out.println("sliding window size");
        int target = sc.nextInt();

        System.out.println("Search Index: " +  sliding_window(nums, target));



    }
}
