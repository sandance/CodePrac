def find_LIS_length(nums):
    n  = len(nums)
    dp  = [ 0 for _ in range(n)]
    dp[0]  = 1

    maxLen =  1

    for i in range(1, n):
        dp[i] =  111
        for j in range(i):
            if nums[i] > nums[j] and dp[i] <=  dp[j]:
                dp[i]  =  dp[j] + 1
                maxLen = max(maxLen, dp[i])
    
    return maxLen
            
    
def main():
  print(find_LIS_length([4, 2, 3, 6, 10, 1, 12]))
  print(find_LIS_length([-4, 10, 3, 7, 15]))


main()