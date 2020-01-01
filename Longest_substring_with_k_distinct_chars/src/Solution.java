import java.io.*;
import java.util.HashMap;


public class Solution {
    /*
    public static int longestSubstringKdistinct(String s, int target) {
        if (s.length() == 0) {
            return 0;
        }

        int start =0, end =0, maxLen = 0;
        int count = 0;
        int [] charMap = new int [128];

        while(end < s.length()) {
            if(charMap[s.charAt(end++)]++ == 0) {
                count++;
            }

            while(count > target) {
                System.out.println("char : " + s.charAt(start)+"\t" + charMap[s.charAt(start)]);
                if(charMap[s.charAt(start++)]-- == 1) {
                    count--;
                }

            }

            maxLen = Math.max(maxLen, end - start );
        }

        return maxLen;
        */
    public static int longestSubstringKdistinct(String s, int target) {
        if (s.length() == 0) {
            return 0;
        }

        int windowStart = 0; 
        //int windowEnd = 0;
        int maxLen = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int windowEnd=0; windowEnd < s.length(); windowEnd++) {
            Char rightChar = s.charAt(windowEnd);

            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while(map.size() > k) {
                char leftChar = s.charAt(windowStart++);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
            }

            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
    
     

    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter string");
        String str = sc.next();


        System.out.println("Enter K");
        int target = sc.nextInt();

        System.out.println("Search Index: " +  longestSubstringKdistinct(str, target));



    }
}
