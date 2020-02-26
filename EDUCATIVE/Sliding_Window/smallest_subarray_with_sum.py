import math

def smallest_subarray_with_sum(arr, S):
    windowSum = 0
    windowStart = 0

    min_length = math.inf

    for windowEnd in range(0, len(arr)):
        windowSum += arr[windowEnd]

        while windowSum >= S:
            min_length = min(min_length, windowEnd - windowStart + 1)
            windowSum -= windowSum[windowStart]
            windowStart += 1
    
    if min_length == math.inf:
        return 0
    return min_length
    