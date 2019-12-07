import java.io.*;


class Solution {
    private static int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;

        while( L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }

        return R - L -1;
    }

    public static String longestPalindrome(String s) {

        if(s== null || s.length() < 1)
            return "";

        int start = 0;
        int end   = 0;

        for(int i=0; i < s.length(); i++) {

            int len1 = expandAroundCenter(s, i, i);
            //System.out.println("i :" + i +"\t" +"Len1 : " + len1);
            int len2 = expandAroundCenter(s, i, i+1);
            //System.out.println("i :" + i +"\t" +"Len2 : " + len2);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len -1) / 2;
                //System.out.println("start : " + start);
                end = i + len /2;
                //System.out.println("end : " + end);
            }
        }

        return s.substring(start, end +1);



    }


    public static int dpSolution(String s) {
        int n = s.length();

        int [][] table = new int [n][n];

        int maxLength = 1;

        for(int i=0; i < n; i++) {
            table[i][i] = 1;

        }

        // check for sub string of length 2
        int start = 0;

        for(int i=0; i < n-1;i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = 1;
                start = i;
                maxLength = 2;
            }
        }


        // check for lengths greater than 2

        for(int k=3; k <= n; k++) {
            for(int i=0; i < n -k + 1; i++) {
                // get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;
                if(table[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = 1;

                    if(k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.println("Longest Palindrome substring: " + s.substring(start, start + maxLength));
        return maxLength;
    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter String");

        String target = sc.next();

        //System.out.println("Longest Palindrome: " + longestPalindrome(target));

        System.out.println("Longest Palindrome: " + dpSolution(target));

    }
}
