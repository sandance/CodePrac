import java.io.*;


public class Solution {

    public static int find_element(int [] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) { // left sorted
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > nums[low]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right sorted
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter number of elements in Arrays");
        int n = sc.nextInt();
        String [] strs = new String[n];

        for (int i=0; i < n; i++) {
            strs[i] = sc.nextLine();
        }



        System.out.println("Common prefix: " +  find_element(strs));



    }
}
