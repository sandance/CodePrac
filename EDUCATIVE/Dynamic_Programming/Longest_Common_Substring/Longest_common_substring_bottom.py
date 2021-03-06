
def find_LCS_bottom(s1, s2):
    n1, n2 = len(s1), len(s2)
    dp = [ [ 0 for x in range(n2 +1 )] for y in range(n1 + 1)]
    maxLength = 0
    for i in range(1, n1+1):
        for j in range(1, n2 + 1):
            if s1[i-1] == s2 [j-1]:
                dp[i][j] = 1 + dp[i-1][j-1]
                maxLength = max(maxLength, dp[i][j])

    return maxLength


def main():
  print(find_LCS_bottom("abdca", "cbda"))
  print(find_LCS_bottom("passport", "ppsspt"))


main()
            