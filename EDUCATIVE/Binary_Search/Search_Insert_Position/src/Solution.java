public class Solution {

    public static int find_insert_position(int [] nums, int target) {
        if (nums == null || nums.length ==0) {
            return 0; // if the array is empty insert at the beginning
        }

        int start = 0, end = nums.length - 1;

        while(start <= end) {
            int mid = start + ( end - start ) /2;

            if (nums[mid] == target)
                return mid;
            else if ( nums[mid] < target) {
                start = mid + 1;
            } else if ( nums[mid] > target) {
                end = mid - 1;
            }
        }
        System.out.println("start : "+ start + " end: " + end);
        return start;
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

        System.out.println("Search Index: " +  find_insert_position(nums, target));
    }
}
