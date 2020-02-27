class Staircase {

    public static int CountWays(int n) {
        if (n == 0) {
            return 1; // base case
        } 

        if ( n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int take1step = CountWays(n-1);
        int take2step = CountWays(n-2);
        int take3step = CountWays(n-3);

        return take1step + take2step + take3step;
    }



    public static int memo (int n) {
        int [] dp = new int [n+1];

        return CountWaysDP(dp, n);

    }

    public static int CountWaysDP(int [] dp, int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (dp[n] == 0) {
            int take1Step = CountWaysDP(dp, n - 1);
            int take2step = CountWaysDP(dp, n - 2);
            int take3step = CountWaysDP(dp, n - 3);

            dp[n] = take1Step + take2step + take3step;
        }

        return dp[n];
    }
}