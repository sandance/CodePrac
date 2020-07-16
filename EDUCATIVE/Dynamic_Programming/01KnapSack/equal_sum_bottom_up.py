def can_partition(num):
    s = sum(num)

    if s % 2 != 0:
        return False

    s = int(s / 2)
    n = len(num)

    dp = [ [False for x in range(s + 1)] for y in range(n)]

    #with only one number , we can form a subset only when the required sum is
    #equal to its value

    for j in range(1, s+1):
        dp[0][j] == num[0] == j

    #process all subset for all sums
    for i in range(1, n):
        for j in range(1, s+1):
            if dp[i-1][j]:
                dp[i][j] = dp[i-1][j]
            elif j >= num[i]:
                dp[i][j] = dp[i-1][j - num[i]]

    return dp[n-1][s]


def main():
  print("Can partition: " + str(can_partition([1, 2, 3, 4])))
  print("Can partition: " + str(can_partition([1, 1, 3, 4, 7])))
  print("Can partition: " + str(can_partition([2, 3, 4, 6])))


main()