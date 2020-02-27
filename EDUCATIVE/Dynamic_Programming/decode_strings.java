class Solution {
    public int numDecodings(String s) {
         
        if (s.length() == 0 || s == null) {
            return 0;
        }
        
        int [] dp = new int [s.length() +1];

        dp [0] = 1;
        dp [1] = s.charAt(0) != 0 ? 1: 0;

        for(int i =2; i <= s.length(); i++) {
            String first = s.substring(i -1, i);
            String second = s.substring(i-2, i);

            int first_digit = String.valueOf(first);
            int second_digit = String.valueOf(second);

            if (first_digit > 0  && first_digit <= 9) {
                dp[i] += digit[i-1];
            } 

            if (second_digit >= 10 && second_digit <= 26) {
                dp[i] += dp[i-2];
            }

            
        }

        return dp[s.length()];
    }
}