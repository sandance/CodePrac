import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static List<List<Integer>> combination_sum(int [] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums ==  null || nums.length == 0) {
            return null;
        }
        backTrack(result, new ArrayList<>(), nums, target, 0);
        return result;

    }

    public static void backTrack(List<List<Integer>> result, List<Integer> tempList, int [] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) result.add(new ArrayList<>(tempList));
        else {
            for(int i= start; i < nums.length; i++) {
                //add a element to tmplist
                tempList.add(nums[i]);
                // see if that leads to a solution
                backTrack(result, tempList, nums, remain - nums[i], i+1);
                tempList.remove(tempList.size() - 1);
            }
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

        System.out.println("Enter the target element");
        int target = sc.nextInt();



        List<List<Integer>> result;
        result = combination_sum(nums, target);

        for(List<Integer> innerLst : result) {
             String arr = innerLst.toString();
             System.out.println(arr);
        }



    }
}
