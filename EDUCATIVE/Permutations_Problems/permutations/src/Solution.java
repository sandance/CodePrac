import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Solution {

    public static List<List<Integer>> permutations (int [] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permute(results, new ArrayList<Integer>(), nums);
        return results;
    }

    public static void permute(List<List<Integer>> results, List<Integer> templist, int [] nums) {
        if (templist.size() == nums.length) results.add(new ArrayList<>(templist));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (templist.contains(nums[i])) continue;
                templist.add(nums[i]);
                permute(results, templist, nums);
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



        System.out.println("Search Index: " + permutations(nums));



    }
}
