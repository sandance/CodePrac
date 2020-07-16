def subset_sum(num, target):
    return subset_sum_recur(num, target, 0)


def subset_sum_recur(num, target, currentIndex):
    if target == 0:
        return True
    
    n = len(num)

    if n == 0 or currentIndex >= n:
        return False

    if num[currentIndex] <= target and subset_sum_recur(num, target - num[currentIndex], currentIndex + 1):
        return True
    
    return subset_sum_recur(num, target, currentIndex + 1)

def main():
    print("Can partition: " + str(subset_sum([1, 2, 3, 4],15)))
    print("Can partition: " + str(subset_sum([1, 1, 3, 4, 7], 7)))
    print("Can partition: " + str(subset_sum([2, 3, 4, 6], 6)))



main()