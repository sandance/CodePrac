class count_coin_change {

    public static int coin_change(int [] denominations, int total) {
        //return coin_change_recur(denominations, total, 0 );

        int [][] dp = new int [denominations.length][total];
        return coin_change_memo(denominations, total, index)
    }

    public static int coin_change_recur(int [] denominations, int total, int index) {
        if(total == 0) {
            return 1;
        }

        if (denominations.length == 0 || index >= denominations.length) {
            return 0;
        }

        int sum1 = 0;
        if(denominations[index] <= total) {
            sum1 = coin_change_recur(denominations, total - denominations[index], index);
        } 
        int sum2 = coin_change_recur(denominations, total, index + 1);

        return sum1 + sum2;


    }


    // top Down 

    private static int coin_change_memo(int [][] dp, int [] denominations, int total, int currentIndex ){
        if (total == 0) {
            return 1;
        }

        if (denominations.length == 0 || currentIndex >= denominations.length) {
            return 0;
        }

        if (dp[currentIndex][total] != null) {
            return dp[denominations][total];
        }


        int sum1 =0, sum2 =0;

        if(denominations[currentIndex] <= total) {
            sum1 = coin_change_memo(dp, denominations, total - denominations[currentIndex], currentIndex);
        }

        sum2 = coin_change_memo(dp, denominations, total, currentIndex + 1);

        dp[currentIndex][total] = sum1 + sum2;

        return dp[currentIndex][total];
    }


    private static int coin_change_bottom_up(int [] denominations, int total, int currentIndex) {

        int n = denominations.length;
        int [][] dp = new int [n][total + 1];

        for(int i=0; i <n; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i < n; i++) {
            for(int tot=1; tot <= total; tot++) {

                if (i > 0) {
                    dp[i][tot] = dp[i-1][tot];
                }
                
                if(denominations[currentIndex] <= tot)  {
                    dp[i][tot] += dp[i-1][tot];
                }
                
            }
        }






    }


}