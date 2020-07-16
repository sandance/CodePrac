def count_change(denominators, target):
    dp = [ [-1 for x in range(target + 11)] for y in range(len(denominators))]
    return count_change_memo(dp, denominators, target, 0)

def count_change_recur(denominators, target, counts, currentIndex):
    if target == 0:
        return 1

    n = len(denominators)
    
    if currentIndex >= n or n == 0:
        return 0

    count1 = 0
    if denominators[currentIndex] <= target:
            count1 = count_change_recur(denominators, target - denominators[currentIndex], counts, currentIndex)

    count2 = count_change_recur(denominators, target, counts, currentIndex + 1)

    return count1 + count2 


def count_change_memo(dp, denominators, target, currentIndex):
    if target == 0:
        return 1

    n = len(denominators)

    if currentIndex >= n or n == 0:
        return 0

    count1 = 0
    if dp[currentIndex][target] != -1:
        if denominators[currentIndex] <= target:
            count1 = count_change_recur(dp, 
                        denominators, target - denominators[currentIndex], currentIndex)

    count2 = count_change_recur(dp, denominators, target, currentIndex + 1)
    dp[currentIndex][target] = count1 + count2

    return dp[currentIndex][target]

def main():
  print(count_change([1, 2, 3], 5))


main()
