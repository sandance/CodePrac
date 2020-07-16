def maximum_increasing_subsequence(nums):
    n = len(nums)
    dp = [ [-1 for x in range(n)] for _ in range(n)]
    return maximum_increasing_subsequence_recur(dp, nums, 0, -1)

def maximum_increasing_subsequence_recur(dp, nums, currentIndex, previousIndex):
    if currentIndex >= len(nums):
        return 0

    sum1, sum2 = 0, 0
    if dp[currentIndex][previousIndex]  == -1:
        if nums[currentIndex] > nums[previousIndex] or previousIndex == -1:
            sum1 = nums[currentIndex] + \
                maximum_increasing_subsequence_recur(dp, 
                    nums, currentIndex + 1, currentIndex)
    
        sum2 = maximum_increasing_subsequence_recur(dp,
            nums, currentIndex + 1, previousIndex)

        dp[currentIndex][previousIndex] = max(sum1, sum2)
    
    return dp[currentIndex][previousIndex]

def main():
  print(maximum_increasing_subsequence([4, 1, 2, 6, 10, 1, 12]))
  print(maximum_increasing_subsequence([-4, 10, 3, 7, 15]))


main()