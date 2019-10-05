import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {

    public static void permutation(List<List<Integer>> result, List<Integer> tempList, int [] array, boolean [] used) {
        if (tempList.size() == array.length) result.add(new ArrayList<>(tempList));
        else {
            for(int i=0; i < array.length; ++i) {
                //if(tempList.contains(array[i]) ) continue;
                if (used[i])
                    continue;

                used[i] = true;
                tempList.add(array[i]);
                System.out.println("tempList: "+ tempList.toString() + "  : index : " + i);
                permutation(result, tempList, array, used );
                //if did not work
                used[i] = false;
                tempList.remove(tempList.size() - 1); // backTrack
                System.out.println("backtracked tempList: "+ tempList.toString() + "  : index : " + i);
                while( i + 1 < array.length && array[i] == array[i+1])
                    ++i;
            }
        }
    }

    public static List<List<Integer>>  permutations(int [] array) {
        if (array.length == 0 || array == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        boolean [] used = new boolean[array.length];
        permutation(result, new ArrayList<Integer>(), array, used);
        return result;

    }

    public static void main(String[] args) {
        // write your code here

        Scanner sc = new Scanner();

        int n = sc.nextInt();
        int [] array = new int [n];

        for(int i=0; i < n; i++) {
            array[i] =sc.nextInt();
        }

        System.out.println("Permutations: " +  permutations(array));



    }
}
