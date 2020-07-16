def rod_cutting(lengths, prices, rod_length):
    return rod_cutting_recur(lengths, prices, rod_length, 0)

def rod_cutting_recur(lengths, prices, rod_length, currentIndex):
    n = len(prices)
    if currentIndex >= n or n == 0 or len(lengths) != n:
        return 0

    

    profit1 = 0
    if lengths[currentIndex] <= rod_length:
        profit1 = prices[currentIndex] + \
            rod_cutting_recur(lengths, prices, rod_length - lengths[currentIndex], currentIndex)

    profit2 = rod_cutting_recur(
        lengths, prices, rod_length, currentIndex + 1)

    return max(profit1, profit2)

def main():
      print(rod_cutting([1, 2, 3, 4, 5], [2, 6, 7, 10, 13], 5))


main()

