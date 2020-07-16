def subset_sum(num, sum):
    n = len(num)
    dp = [[False for x in range(sum + 1)] for y in range(n)]

    for i in range(n):
        dp[i][0] = True

    #with only one number , we can form a subset if the required sum equal to its value
    for s in range(1, sum + 1):
        dp[0][s] = True if num[0] == s else False


    #rest of the matrix

    for i in range(1, n):
        for s in range(1, sum + 1):
            #with including if possible to get a subset
            if dp[i-1][s]:
                dp[i][s] = dp[i-1][s]
            elif s >= num[i]:
                dp[i][s] = dp[i-1][s-num[i]]

    return dp[n-1][s]


def main():
  print("Can partition: " + str(subset_sum([1, 2, 3, 7], 6)))
  print("Can partition: " + str(subset_sum([1, 2, 7, 1, 5], 10)))
  print("Can partition: " + str(subset_sum([1, 3, 4, 8], 6)))


main()
