def unbounded_knapsack(weights, profits, capacity):
    n = len(weights)
    dp = [ [-1 for x in range(capacity + 1)] for y in range(n)]
    return unbounded_knapsack_recursive(dp, weights, profits, capacity, 0)


def unbounded_knapsack_recursive(dp, weights, profits, capacity, currentIndex):
    n = len(weights)

    if capacity <= 0 or n == 0 or len(weights) != n or currentIndex >= n:
        return 0

   
    if dp[currentIndex][capacity] == -1:
        profit1 = 0
        if weights[currentIndex] <= capacity:
            profit1 = profits[currentIndex] + unbounded_knapsack_recursive(dp, weights,
                        profits, capacity - weights[currentIndex] , currentIndex)
        # recursive call after excluding the element at the currentIndex
        profit2 = unbounded_knapsack_recursive(dp, weights, profits, capacity, currentIndex + 1)

        dp[currentIndex][capacity] = max(profit1, profit2)

    return dp[currentIndex][capacity]

def main():
    print(unbounded_knapsack([15, 50, 60, 90], [1, 3, 4, 5], 8))
    print(unbounded_knapsack([15, 50, 60, 90], [1, 3, 4, 5], 6))


main()



