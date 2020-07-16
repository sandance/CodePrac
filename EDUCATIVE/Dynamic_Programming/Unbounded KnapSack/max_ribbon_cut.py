import math.imf

def count_ribbon_places(lengths, total):
    result = count_ribbon_places_recur(lengths, total, 0)
    return -1 if result == math.inf else result

def count_ribbon_places_recur(lengths, total, currentIndex):
    n = len(lengths)

    if total == 0:
        return 0
    
    if currentIndex >= n or n == 0:
        return -math.inf

    count1 = -math.inf
    if lengths[currentIndex] <= total:
        res = count_ribbon_places_recur(lengths, total - lengths[currentIndex], currentIndex)
        if res != math.inf:
            count1 = res + 1
    
    count2 = count_ribbon_places_recur(lengths, total, currentIndex + 1)

    return min(count1 , count2) 



def main():
  print(count_ribbon_pieces([2, 3, 5], 5))
  print(count_ribbon_pieces([2, 3], 7))
  print(count_ribbon_pieces([3, 5, 7], 13))
  print(count_ribbon_pieces([3, 5], 7))


main()