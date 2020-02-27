
class KnapSack {

    public int solveKnapSack(int [] profits, int [] weights, int capacity) {
        return KnapSackRecur(profits, weights, capacity, 0);
    }

    public static int KnapSackRecur(int [] profits, int [] weights, int capacity, int currentIndex) {
        // base check

        if(capacity <= 0 || profits.length == 0 || weights.length != profits.length || currentIndex >= profits.length) {
            return 0;
        } 

        int profit1 = 0;
        if (weights[currentIndex] <= capacity) { // include the item 
            profit1 = profits[currentIndex] + KnapSackRecur(profits, weights, capacity - weights[currentIndex],
             currentIndex);
        }
        // recursive call after excluding the element at the currentIndex

        int profit2 = KnapSackRecur(profits, weights, capacity , currentIndex + 1);

        return Math.max(profit1, profit2);
    }
}