import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Solution {

    public static List<List<Integer>> find_combinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        combinations(result, new ArrayList<Integer>(), 1, n, k);
        return result;

    }

    private static void combinations(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        if (k==0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=start; i <= n; i++ ) {
            tempList.add(i);
            combinations(result, tempList, i+1, n, k -1);
            tempList.remove(tempList.size() -1);
        }

    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter number of elements in Arrays");
        int n = sc.nextInt();
        int k = sc.nextInt();


        System.out.println("Search Index: " +  find_combinations(n, k));



    }
}
