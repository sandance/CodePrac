
class ribbon_cut {

    public static int ribbon_cut(int [] lengths, int total) {

        return ribbon_cut_recur(lengths, total, 0);
    }

    private static int ribbon_cut_recur(int [] lengths, int total, int currentIndex) {

        if (total == 0) {
            return 0;
        }

        

        if (lengths.length == 0 || currentIndex >= lengths.length) {
            return Integer.MIN_VALUE;
        }
        int c1 = Integer.MIN_VALUE;
        int sum1 = 0;
        if(lengths[currentIndex] <= total) {
            //including
            sum1 = ribbon_cut_recur(lengths, total - lengths[currentIndex], currentIndex );
        }

        if(sum1 != Integer.MIN_VALUE) {
            c1 = sum1 + 1;
        }

        int  c2 = ribbon_cut_recur(lengths, total, currentIndex + 1);
        return Math.max(c1, c2);

    }

    private static int ribbon_cut_dp(int [] ribbonLengths, int total, int currentIndex) {
        
        int n = ribbonLengths.length;

        // return 0; 
        int [][] dp = new int [n][total];

        for(int i=0; i <n; i++) {
            dp[i][0] = 1;
        }

        if (dp[currentIndex][total] != null) {
            return dp[currentIndex][total];
        }

        int c1 = Integer.MIN_VALUE;
        for(int i=0; i <n; i++) {
            for(int len=1; len < total; len++) {
            
                if(i>0) {
                    dp[i][len] = dp[i-1][len];
                }

                if(ribbonLengths[i] <= len && dp[i][len - ribbonLengths[i]] != Integer.MIN_VALUE)

                
            }
        }
    }




}