def minimum_subset_difference(num):
    s = sum(num)
    dp = [ [-1 for y in range(s+1)] for x in range(len(num)) ]
    return can_partition_recursive(dp, num, 0, 0, 0)


def can_partition_recursive(dp, num, currentIndex, sum1, sum2):
    if currentIndex == len(num):
        return abs(sum1 - sum2)

    if dp[currentIndex][sum1] == -1:
        diff1 = can_partition_recursive(dp, num, currentIndex + 1, sum1 + num[currentIndex], sum2)

        diff2 = can_partition_recursive(dp, num, currentIndex + 1, sum2 + num[currentIndex], sum2)

        dp[currentIndex][sum1] = min(diff1 ,diff2)

    return dp[currentIndex][sum1]