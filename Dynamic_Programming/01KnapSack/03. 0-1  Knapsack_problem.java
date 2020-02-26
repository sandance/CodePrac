
class Solution {
    public static int solveKnapsack(int [] profits, int [] weights, int capacity) {
        int [][] dp = new int [profits.length][capacity + 1];
        return knapsackRecursive(dp, profits, weights, capacity, 0);
    }


    public static int knapsackRecursive(int [][] dp, int [] profits, int [] weights, int capacity, int currentIndex) {
        // base case
        if (capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }

        if(dp[currentIndex] != null){
            return dp[currentIndex][capacity];
        }

        int profit1 = 0;
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights, 
            capacity - weights[currentIndex], currentIndex + 1);
        }

        // recur 

        int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);

        dp[currentIndex][capacity] = Math.max(profit1, profit2);

        return dp[currentIndex][capacity]; 
    }
}