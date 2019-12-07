import java.io.*;


public class Solution {

        public static void printArr(int [] nums) {
            for(int i=0; i < nums.length; i++) {
                System.out.print(nums[i]+ " ");
            }
            System.out.println();
        }
        /*
        public static int removeDuplicates(int[] nums) {

            int j = 0;
            int i = 1;

            while (i < nums.length) {
                if (nums[i] != nums[j]) {
                    j++;
                    nums[j] = nums[i];
                    printArr(nums);
                }
                i++;
            }
            return j + 1;
        }*/

    public static int removeDuplicates(int[] nums) {
        int left =2;
        for(int right = 2 ; right < nums.length; ++right) {
            if(nums[left -2] != nums[right]) {
                System.out.println("Index: " + (left -2)+ "\t"+"Left :"+left+ "\t"+"Right: "+ right);

                nums[left++] = nums[right];
                printArr(nums);
            }
        }
        return left;
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

        System.out.println("Total elements: " +  removeDuplicates(nums));



    }
}
