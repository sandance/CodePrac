import jdk.internal.net.http.websocket.WebSocketImpl;

class Rod_Cutting {
    
    public static int max_cut_rod_recur(int [] lengths, int [] profits, int rlength, int index) {
        if(index >= profits.length) {
            return 0;
        }

        if(rlength <= 0 || profits.length == 0 || weights.length){
            return 0;
        }

        int profit1 = 0, profit2 = 0;

        if(lengths[index] <= rlength ) {
            profit1 = profits[index] + max_cut_rod_recur(lengths, profits, rlength - lengths[index], index);
        }
        profit2 = max_cut_rod_recur(lengths, profits, rlength, index+1);

        return Math.max(profit1, profit2);

    }

    public static int max_cut_rod_DP (int [] lengths, int [] prices, int n) {
        return max_cut_rod_recur(lengths, prices, n, 0);
    }


    public static int max_cut_rod_dp (int [] lengths, int [] prices, int n) {
        if (n <= 0 ||  lengths.length != prices.length || prices.length == 0) {
            return 0;
        }

        int lengthCount = lengths.length;

        int [][] dp = new int [lengthCount][n];

        for(int i=0; i <prices.length; i++) {
            dp[i][0] = 0;
        }

        for (int i=0; i < lengthCount; i++) {
            for(int len=0; len < n; j++) {
                int p1 = 0, int p2 = 0;
                if(lengths[i] <= n) {
                  p1 = prices[i] + dp[i][len - lengths[i]];
                }
                if (i > 0) {
                    p2 = dp[i-1][len];
                }

                dp[i][len] = Math.max(p1, p2);
            }
        
        }

        return dp[lenghCount - 1][n];

        
    }
}