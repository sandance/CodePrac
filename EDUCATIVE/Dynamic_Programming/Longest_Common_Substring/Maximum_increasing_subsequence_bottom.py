def maximum_increasing_subsequence(nums):
    n = len(nums)
    dp = [ [0 for _ in range(n)] for _ in range(n)]

    dp[0]  =  nums[0]
    maxSum = 0

    for i in range(1,n):
        dp[i] = nums[i]
        for j in range(i):
            if nums[i] > nums[j] and dp[i] < dp[j] + nums[i]:
                dp[i] = dp[j] + nums[i]
        maxSum = max(maxSum, dp[i])
    
    return maxSum

def main():
  print(maximum_increasing_subsequence([4, 1, 2, 6, 10, 1, 12]))
  print(maximum_increasing_subsequence([-4, 10, 3, 7, 15]))


main()