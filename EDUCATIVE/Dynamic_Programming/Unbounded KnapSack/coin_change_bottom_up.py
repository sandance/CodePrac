def count_change_bottom_up(denominators, total):
    n = len(denominators)
    dp = [ [0 for x in range(total + 1)] for y in range(n)]

    #populate the total = 0 , we will always have an empty set for zero total
    for i in range(n):
        dp[i][0] =  1

    for i in range(n):
        for t in range(1, total + 1):
            if i > 0:
                #exclude the coin, count all the coin combinations wwithout the given coin upto t
                dp[i][t]  = dp[i-1][t]
            if t >= denominators[i]:
                dp[i][t] += dp[i][t - denominators[i]]
    
    return dp[n-1][total]



def main():
      print(count_change_bottom_up([1, 2, 3], 5))


main()