import math.inf

def minimum_coin_change_bottom_up(denominator, total):
    n = len(denominator)
    dp =  [[math.inf for _ in range(total + 1)] for y in range(n)]

    for i in range(n):
        dp[i][0] = 0

    for i in range(n):
        for t in range(1, total + 1):
            if i > 0:
                #exclude the item and consider all coins to this point
                dp[i][t] = dp[i-1][t] 
            if t >= denominator[i]:
                if dp[t - denominator[i]] != math.inf:
                    dp[i][t] = min(dp[i][t], dp[i][t  - denominator] + 1) #include the coin
    
    return -1 if dp[n-1][total] == math.inf else dp[n-1][total]



def main():
  print(minimum_coin_change_bottom_up([1, 2, 3], 5))
  print(minimum_coin_change_bottom_up([1, 2, 3], 11))
  print(minimum_coin_change_bottom_up([1, 2, 3], 7))
  print(minimum_coin_change_bottom_up([3, 5], 7))


main()   


