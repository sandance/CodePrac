import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;



public class Solution {
    /***
     *
     * @param nums  Array
     * @param results List to store all the other list
     * @param temp_list Temp list of each combination
     * @param s_size set size
     * @param t_size list size so far
     * @param temp_sum temp_sum so far
     * @param index index of the node
     * @param target sum to be found
     * @return
     */
    public static int total_nodes = 0;

    public static int subset_sum_util(int [] nums, List<ArrayList<Integer>> results, ArrayList<Integer> temp_list, int s_size, int t_size, int temp_sum, int index, int target){
        total_nodes++;

        if (target == temp_sum) {
            subset_sum_util(nums, results, temp_list., s_size, t_size - 1, temp_sum - nums[index], index+1, target );

        } else {
            for (int i=index; i <= s_size; i++) {
                temp_list.add(nums[i])
                subset_sum_util(nums, results, temp_list, s_size, t_size + 1, temp_sum + nums[i], i, target )
            }
        }


    }

    public static List<Integer> sumset_sum (int [] nums, int target) {
        if (nums == null || nums.length == 0)
            return null;

        List<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

        subset_sum_util(nums, results, new ArrayList<Integer>() , nums.length , 0, 0 , 0, target);

        return results;
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

        System.out.println("Search Index: " +  sumset_sum(nums, target));



    }
}
