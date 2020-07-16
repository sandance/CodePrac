
from heapq import *
import heapq

class SlidingWindowMedian:
    def __init__(self):
        self.maxHeap, self.minHeap = []

    def find_sliding_median(self, nums, k):
        result = [0.0 for x in range(len(nums) - k +1)]
        for i in range(0, len(nums)):
            if not self.maxHeap or nums[i] <= -self.maxHeap[0]:
                heappush(self.maxHeap, -nums[i])
            else:
                heappush(self.minHeap, nums[i])

            