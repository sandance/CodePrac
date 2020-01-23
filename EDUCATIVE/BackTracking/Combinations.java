import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n) {
            return result;
        }

        combine_Helper(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    public static void combine_Helper(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        if ( k == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        } 

        for (int i = start; i <= n; i++) {
            tempList.add(i);
            combine_Helper(result, tempList, i+1, n, k-1);
            result.remove(result.size() - 1);
        }
    }
}