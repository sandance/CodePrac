from heapq import *

def find_k_smallest_elements(nums, k):
    maxHeap = []

    for i in range(k):
        heappush(maxHeap, -nums[i])

    for i in range(k, len(nums)):
        if -nums[i] > maxHeap[0]:
            heappop(maxHeap)
            heappush(maxHeap, nums[i])
    
    return list(maxHeap)



def main():
    print ("k smallest elements " + str(find_k_smallest_elements([3,1,4,5,2,0], 3)))


main()