import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {

    public static List<List<Integer>> subsets(int [] nums) {
       if (nums == null || nums.length == 0)
           return null;

       List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        boolean [] used = new boolean[nums.length];
        helper(result, new ArrayList<>(), 0, nums, used);
        return result;

    }

    private static void helper(List<List<Integer>> result, List<Integer> tempList, int start, int [] nums, boolean [] used) {
        result.add(new ArrayList<>(tempList));
        for(int i=start; i <nums.length; i++ ) {
            if (used[i]){
                continue;
            }
            used[i] = true;
            tempList.add(nums[i]);
            helper(result, tempList, i+1, nums, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
            while ( i+1 < nums.length && nums[i] == nums[i+1])
                ++i;
        }
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


        System.out.println("Search Index: " +  subsets(nums));
    }
}
