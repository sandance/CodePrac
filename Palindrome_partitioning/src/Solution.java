import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Solution {

    private static void backTrack(List<List<String>> result, List<String> tempList, String str, int start) {
        if (start == str.length())
            result.add(new ArrayList<>(tempList));

        else {

            for(int i=start; i < str.length(); i++) {
                if (isPlaindrome(str, start, i)) {
                    tempList.add(str.substring(start, i+1));
                    backTrack(result, tempList, str, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private static boolean isPlaindrome(String str, int low, int high) {
        while(low <= high) {
            if (str.charAt(low++) != str.charAt(high--))
                return false;
        }
        return true;
    }

    public static List<List<String>> palindrome_partition(String str) {
        List<List<String>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), str, 0);
        return result;


    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter the string");
        String str = sc.next();

        System.out.println("Search Index: " +  palindrome_partition(str));



    }
}
