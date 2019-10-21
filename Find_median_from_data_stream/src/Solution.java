import java.io.*;
import java.util.*;


public class Solution {

   private static Queue<Long> bigHeap = new PriorityQueue<>();
   private static Queue<Long> smallHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void addNum(int num) {
        bigHeap.offer((long) num);
        smallHeap.offer(bigHeap.poll());
        //if (bigHeap.size() < )
        if (bigHeap.size() < smallHeap.size())
            bigHeap.offer(smallHeap.poll());
    }

    /*
    If same size
    average lower max and higher min

    if different
    max of lower and min of higher (which over is bigger)
    */

    public static long find_median() {
        if (bigHeap.size() > smallHeap.size()) {
            return bigHeap.peek();
        }

        return (long)(bigHeap.peek() + smallHeap.peek()) / 2;
    }



    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter number of elements in Arrays");
        int n = sc.nextInt();
        int [] nums = new int[n];

        for (int i=0; i < n; i++) {
            nums[i] = sc.nextInt();
            addNum(nums[i]);
        }

        System.out.println("Big Heap : " + Arrays.toString(bigHeap.toArray()));
        System.out.println("Small Heap : " + Arrays.toString(smallHeap.toArray()));



        System.out.println("Median: " +  find_median());



    }
}
