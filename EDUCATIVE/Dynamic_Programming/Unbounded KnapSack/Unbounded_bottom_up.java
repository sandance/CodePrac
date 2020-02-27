
class KnapSack {

    public int solveKnapSack(int[] profits, int[] weights, int capacity) {
        return KnapSackBottomUp(profits, weights, capacity, 0);
    }

    public static int KnapSackBottomUp(int[] profits, int[] weights, int capacity, int currentIndex) {
        // base check

        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length
                || currentIndex >= profits.length) {
            return 0;
        }

        int n = profits.length;
        int [][] dp = new int [n][capacity];

        // populate the capacity = 0, 0 capacity has 0 profit
        for(int i=0; i < n;i++) {
            dp[0][i] = 0;
        }

        // if we have only one weight
        for(int c = 0; c <= capacity; c++) {
            if(weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }



        for(int i=1; i < n; i++) {
            for(int c=1; c <= capacity; c++) {
                int profit1 = 0, profit2 =0;
                if(weights[i] <= c) {
                    profit1 = profits[i] + dp[i-1][c-weights[i]];
                }
                //exclude
                if ( i >0)
                    profit2 = dp[i-1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        return dp[n-1][capacity];
    }
}