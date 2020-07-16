def two_sum(nums, k):
    num_set = set()
    for i in nums:
        if k-i in num_set:
            return True
        else:
            num_set.add(i)
    return False

print (two_sum([10,15,3,7] , 19))

from bisect import bisect_left

def binary_search(nums, target):
    lo = 0
    hi = len(nums)

    ind = bisect_left(nums, target, lo, hi)

    if 0 <= ind < hi 
