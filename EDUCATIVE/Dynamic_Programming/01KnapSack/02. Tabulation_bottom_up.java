

class Fibonacci {
    /*

    Tabulation is the opposite of the top-down approach and avoids recursion. 
    In this approach, we solve the problem “bottom-up” (i.e. by solving all the related 
    sub-problems first). This is typically done by filling up an n-dimensional table.
    Based on the results in the table, the solution to the top/original problem is then computed.
     */

    public int CalculateFibonacci (int n) {

        int [] dp = new int [n+1];

        // base case
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public int solveKnapsack(int [] profits, int [] weights, int capacity) {
        if(capacity <= 0 || profits.length == 0 || weights.length != profits.length) {
            return 0;
        }


        int n = profits.length;
        int [][] dp = new int [n][capacity + 1];
        
        // populate the capacity = 0 column with "0" capacity we have "0" profit
        for(int i=0; i < n; i++) {
            dp[i][0] = 0;
        }

        // If we have only one weight , we will take it if it is not more than capacity
        for(int c=0; c <= capacity; c++) {
            if(weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }


        //process all sub arrays for all the capabilities
        for(int i=1; i < n; i++) {
            for(int c = 1; c <= capacity; c++) {
                int profit1 = 0; int profit2 = 0;
                // include the item
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i-1][capacity];
                }
                // exclude the item
                profit2 = dp[i-1][c];
                //take maximum
                dp[i][c] = Math.max(profit1, profit2);
            }
        }
    }
}