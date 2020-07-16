from heapq import *

def find_k_largest_numbers(nums, k):
    minHeap = []
    #put first k elements into the list
    for i in range(k):
        heappush(minHeap, nums[i])

    #go through remaining numbers
    for i in range(k, len(nums)):
        if nums[i] > minHeap[0]:
            heappop(minHeap)
            heappush(minHeap, nums[i])
        
    return list(minHeap)

def main():
    print("Here are the top K elements " + str(find_k_largest_numbers([3,1,5,12,2,11], 3)))

