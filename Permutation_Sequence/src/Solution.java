import java.io.*;
import java.util.*;


public class Solution {

    public static void  find_permutaions(int [] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        permutation_k(result, new ArrayList<Integer>(), nums);
        Iterator<List<Integer>> iter = result.iterator();
        int counter = 0;
        while(iter.hasNext()) {
            counter++;
            List<Integer> value = iter.next();
            if (counter==k) {
                System.out.print(value);

            }
        }
    }


    private static void permutation_k(List<List<Integer>> result, List<Integer> templist, int [] nums ) {
        if ( templist.size() == nums.length) result.add(new ArrayList<>(templist));
        else {
            for(int i=0; i < nums.length; i++) {
                if (templist.contains(nums[i])) continue;
                templist.add(nums[i]);
                permutation_k(result, templist, nums);
                templist.remove(templist.size() - 1);
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

       find_permutaions(nums, target);

    }
}
