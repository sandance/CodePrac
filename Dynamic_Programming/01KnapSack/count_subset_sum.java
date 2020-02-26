class Solution{

    //brute force sol

    public static int count_subset_sum(int [] nums, int sum) {

        // for DP

        Integer [][] dp = new Integer[nums.length][sum];

        return countSubsetDP(dp, nums, sum, 0);

    }


    private static int countSubsetRecur(int [] nums, int sum, int currentIndex) {
        if(sum == 0) {
            return 1;
        }

        if(nums.length == 0 || currentIndex >= nums.length) {
            return 0;
        }

        int sum1 = 0;

        if(nums[currentIndex] <= sum) {
            sum1 = countSubsetRecur(nums, sum - nums[currentIndex], currentIndex + 1);
        }

        //recursively call after excluding the number at the currentIndex
        int sum2 = countSubsetRecur(nums, sum, currentIndex + 1);

        return sum1 + sum2;
    }



    public static int countSubsetDP(Integer [][] dp, int [] nums, int sum, int currentIndex) {


        if (sum == 0) {
            return 1;
        }

        if (nums.length == 0 || currentIndex >= nums.length) {
            return 0;
        }
        if(dp[currentIndex][sum] == null) { 
            int sum1 = 0;

            if(nums[currentIndex] <= sum) {
                sum1 = dp[currentIndex][sum] = countSubsetDP(dp, nums, sum - nums[currentIndex], currentIndex + 1);
            }

            int sum2 = countSubsetDP(dp, nums, sum, currentIndex + 1);

            dp[currentIndex][sum] = sum1 + sum2;
        }

        //return dp[currentIndex][sum];

        return dp[currentIndex][sum];

        

    }
}