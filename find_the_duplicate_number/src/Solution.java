import java.io.*;


public class Solution {

    public static int find_duplicate(int [] nums) {
        int n = nums.length;
        int slow = n;
        int fast = n;

        do {
            slow = nums[slow - 1];
            fast = nums[nums[fast - 1] -1 ];
            System.out.println("Slow pointer: " + slow +"\t" + "Fast pointer: " + fast );
        } while(slow != fast);

        slow = n;

        while( slow != fast) {;.
            slow = nums[slow -1];
            fast = nums[fast - 1];
        }



        return slow;
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

        System.out.println("Search Index: " +  find_duplicate(nums));



    }
}
