def max_sub_array_of_size_k(k, arr):
    windowSum = 0
    maxSum = 0
    windowStart = 0

    for windowEnd in range(len(arr)):
        windowSum += arr[windowEnd]
        if windowEnd >= k -1:
            maxSum = max(maxSum, windowSum)
            windowSum -= arr[windowStart]
            windowStart +=1
    return maxSum

