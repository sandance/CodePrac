from heapq import *
from collections import defaultdict

def find_k_frequent_numbers(nums, k):
    freq_nums = defaultdict(int)
    for i in nums:
        freq_nums[i] += 1
    
    minHeap = []

    for num,frequency in freq_nums.items():
        heappush(minHeap, (frequency,num))
        if len(minHeap) > k:
            heappop(minHeap)
    
    #create a list of top k numbers
    topNumbers = [] 
    while minHeap:
        topNumbers.append(heappop(minHeap)[1])
    
    return topNumbers


