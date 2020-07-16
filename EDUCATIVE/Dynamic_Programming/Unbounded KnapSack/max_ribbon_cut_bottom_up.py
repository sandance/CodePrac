
import math

def count_ribbon_pieces_bottom_up_bottom_up(lengths, total):
    n = len(lengths)
    dp = [ [ -math.inf for x in range(total + 1)] for y in range(n)]

    for i in range(n):
        dp[i][0] = 0
    
    for i in range(n):
        for t in range(1,total + 1):
            if i > 0:
                dp[i][t] = dp[i-1][t]
            if lengths[i] <= t and dp[i][t- lengths[i]] !=  -math.inf:
                dp[i][t] = max(dp[i][t], dp[i][t - lengths[i]]  + 1 )# include
            
    return -1 if dp[n-1][total] == -math.inf else dp[n-1][total]
    
    return dp[n-1][total]


def main():
    print(count_ribbon_pieces_bottom_up([2, 3, 5], 5))
    print(count_ribbon_pieces_bottom_up([2, 3], 7))
    print(count_ribbon_pieces_bottom_up([3, 5, 7], 13))
    print(count_ribbon_pieces_bottom_up([3, 5], 7))


main()
