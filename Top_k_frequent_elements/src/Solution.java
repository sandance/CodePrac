import java.io.*;
import java.util.HashMap;
import java.util.*;


public class Solution {

    public static List<Integer> top_k_element(int [] nums, int k) {
        if (nums == null || nums.length == 0)
            return null;

        Map<Integer, Integer> frequenceMap = new HashMap<Integer, Integer>();

        for ( int n : nums) {
            frequenceMap.put(n, frequenceMap.getOrDefault(n, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        for(Map.Entry<Integer, Integer> entry : frequenceMap.entrySet()) {
            heap.offer(entry);
        }

        List<Integer> res = new ArrayList<>();
        while(k-- > 0) {
            res.add(heap.poll().getKey());
        }

        return res;
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

        System.out.println("Enter the number of elements : k ");
        int target = sc.nextInt();

        System.out.println("Search Index: " +  top_k_element(nums, target));



    }
}
