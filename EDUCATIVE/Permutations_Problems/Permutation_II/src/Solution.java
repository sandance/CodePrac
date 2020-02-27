import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Solution {

    public static void permutation(List<List<Character>> result, List<Character> tempList, char [] array) {
        if (tempList.size() == array.length) result.add(new ArrayList<>(tempList));
        else {
            for(int i=0; i < array.length; i++) {
                if(tempList.contains(array[i])) continue;
                tempList.add(array[i]);
                permutation(result, tempList, array);
                tempList.remove(tempList.size() - 1); // backTrack
            }
        }
    }

    public static List<List<Character>>  string_permutations(char [] array) {
        if (array.length == 0 || array == null) {
            return null;
        }

        List<List<Character>> result = new ArrayList<>();

        boolean [] used = System.out.println("tempList: "+ tempList.toString() + "  : index : " + i);

        permutation(result, new ArrayList<Character>(), array);
        return result;

    }

    public static void main(String[] args) {
        // write your code here

        Scanner sc = new Scanner();

        String str = sc.next();

        System.out.println("Search Index: " +  string_permutations(str.toCharArray()));



    }
}
