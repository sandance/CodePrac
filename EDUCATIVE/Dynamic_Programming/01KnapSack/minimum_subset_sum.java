class PartitionSet {

    public int canPartition(int [] nums) {
        int sum = 0;

        for(int i=0; i < nums.length; i++) {
            sum += nums[i];
        }

        int n = nums.length;
        boolean [][] dp = new boolean[n][sum/2 + 1];

        for(int i=0; i < n; i++){
            dp[i][0] = true;
        }

        for(int s=1; s < sum / 2 +1 ; i++) {
            dp[0][s] = (nums[0] == s ? true : false) ;
        }

        // process all subsets for all sums

        for(int i=0; i < nums.length; i++) {
            for(int s=1; s <= sum /2 ; s++) {
                //if we can get sum 's' without including the item
                if(dp[i-1][s]) {
                    dp[i][s] = dp[i-1][s];
                } else if (s >= nums[i]) {
                    dp[i][s] = dp[i-1][s - nums[i]];
                }
            }
        }


        // now look backward to find first true 

        int sum1 = 0;

        for(int i = sum /2; i >= 0; i--) {
            if (dp[n-1][i] == true) {
                sum1 = i;
                break;
            }
        }

        int sum2 = sum - sum1;

        return Math.abs(sum2 - sum1);
    }
}