class Solution {

    //bottom -up approach

    public static boolean subset_sum(int [] nums, int target) {

        boolean [][] dp = new boolean [nums.length][target];
        // sum 0
        for(int i=0; i < n; i++) {
            dp[i][0] = true;
        }

        for(int i=1; i < target; i++) {
            if(nums[i-1] == i) {
                dp[0][i] = true;
            } else {
                dp[0][i] = false;
            }

        }

        for(int i=1; i <= dp.length; i++) {
            for(int s=1; s <= target; s++) {
                if(dp[i-1][s]) {
                    //exclude
                    dp[i][s] = dp[i-1][s];
                } else if ( s >=  nums[i]) {
                    dp[i][s] = dp[i-1][s-nums[i]];
                }

            }
        }

        return dp[nums.length - 1][target];
    }
}