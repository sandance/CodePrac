import java.io.*;


public class Solution {

    public static int find_element(int [] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) { // left sorted
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] > target) {
                high = mid - 1;

            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return nums[high];
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

        System.out.println("Search Index: " +  find_element(nums, target));



    }
}
