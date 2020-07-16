def find_LIS(nums):
    return find_LIS_recur(nums,0,-1)

def find_LIS_recur(nums, currentIndex, previousIndex):
    n = len(nums)
    if currentIndex >= n:
        return 0
    c1  = 0

    if previousIndex == -1 or nums[currentIndex] > previousIndex:
        return c1 + find_LIS_recur(nums, currentIndex + 1, currentIndex)
    
    #excluding the number at currentIndex
    c2 = find_LIS_recur(nums, currentIndex +1  , previousIndex)

    return max(c1, c2)

def main():
  print(find_LIS([4, 2, 3, 6, 10, 1, 12]))
  print(find_LIS([-4, 10, 3, 7, 15]))


main()



