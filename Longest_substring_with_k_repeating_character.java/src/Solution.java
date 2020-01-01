import java.io.*;


public class Solution {


    public static int longestSubstring(String s, int k) {

        char [] str = s.toCharArray();
        return helper(str, 0, s.length(), k);

    }

    public static int helper(char [] str, int start, int end, int k) {
        if ( end - start < k) {
            return 0;
        }

        int [] count = new int[26];

        for(int i=start; i < end; i++) {
            int index = str[i] - 'a';
            count[index]++;
        }

        for(int i=0; i < 26; i++) {
            if(count[i] < k && count[i] > 0) {
                for(int j=start; j < end; j++) {
                    if(str[j] == i +'a') {
                        // get rid of this element
                        System.out.println(str[j]);
                        int left = helper(str, start, j, k);
                        System.out.println("Left: " + left);
                        int right = helper(str, j+1, end, k);
                        System.out.println("Right: " + right);
                        return Math.max(left, right);
                    }
                }

            }
        }
        return end - start;
    }


    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter String");
        String str = sc.next();

        System.out.println("Enter k value");
        int k = sc.nextInt();

        System.out.println("Longest substring: " + longestSubstring(str, k));




    }
}
