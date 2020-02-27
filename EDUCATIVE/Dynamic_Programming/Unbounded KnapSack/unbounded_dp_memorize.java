class KnapSack {

    public int solveKnapSack(int[] profits, int[] weights, int capacity) {
        Integer [][] dp = new Integer [profits.length][capacity+1];
        return KnapSackRecur(dp, profits, weights, capacity, 0);
    }

    public static int KnapSackRecur(Integer [][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
        // base check

        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length
                || currentIndex >= profits.length) {
            return 0;
        }

        if(dp[currentIndex][capacity] != null) {
            return dp[currentIndex][capacity];
        }

        int profit1 = 0;
        if (weights[currentIndex] <= capacity) { // include the item
            profit1 = profits[currentIndex]
                    + KnapSackRecur(dp, profits, weights, capacity - weights[currentIndex], currentIndex);
        }
        // recursive call after excluding the element at the currentIndex

        int profit2 = KnapSackRecur(dp, profits, weights, capacity, currentIndex + 1);

        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }


    // Rod Cutting Bottom Up

    public int solveKnapSack(int[] profits, int[] weights, int capacity) {

        if (capacity <= 0 || weights.length == 0 || profits.length == 0 ) {
            return 0;
        }

        int [][] dp = new int [profits.length][capacity];

        //


}