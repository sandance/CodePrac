import java.io.*;


public class Solution {

    public static int target_sum(int [] nums, int target) {
        return findTargetSum(0, nums, target);
    }

    private static int findTargetSum(int index, int [] nums, int target) {
        if(index == nums.length) {
            // all numbers are added
            if(target == 0)
                return 1;
            else
                return 0;
        }

        return findTargetSum(index + 1, nums, target + nums[index])
                + findTargetSum(index + 1, nums, target - nums[index]);
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

        System.out.println("Search Index: " +  target_sum(nums, target));



    }
}
