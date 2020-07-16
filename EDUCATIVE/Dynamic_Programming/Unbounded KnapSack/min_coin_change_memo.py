import math

def min_coin_change(denominators, total):
    return min_coin_change_recur(denominators, total, 0)


def min_coin_change_recur(denominators, total, currentIndex):
    n = len(denominators)
    if total == 0:
        return 0
    
    if currentIndex >= n or n == 0:
        return math.inf

    
    count1 = math.inf
    if denominators[currentIndex] < total:

        #Include the item
        res = min_coin_change_recur(denominators, total - denominators[currentIndex], currentIndex)
        if res != math.inf:
            count1  = res + 1
    count2 = min_coin_change_recur(
        denominators, total, currentIndex +1)

    return min(count1 , count2)


def main():
  print(min_coin_change([1, 2, 3], 5))
  print(min_coin_change([1, 2, 3], 11))
  print(min_coin_change([1, 2, 3], 7))
  print(min_coin_change([3, 5], 7))


main()




