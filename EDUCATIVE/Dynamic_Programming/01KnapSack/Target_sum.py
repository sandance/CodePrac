
def find_target_sum(nums, target):
    totalSum = sum(nums)

    if totalSum <= target or (target + totalSum)/2 == 1:
        return 0
    
    return target_sum_bottom_up(nums, totalSum, target)



def target_sum_bottom_up(nums, totalSum, target):
     n = len(nums)

     dp = [ [0 for i in range(target)] for y in range(n)]

     