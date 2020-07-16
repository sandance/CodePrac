def find_LCS_length(s1, s2):
  return find_LCS_length_recursive(s1, s2, 0, 0)


def find_LCS_length_recursive(s1, s2, i1, i2):
  if i1 == len(s1) or i2 == len(s2):
    return 0

  if s1[i1] == s2[i2]:
    return 1 + find_LCS_length_recursive(s1, s2, i1 + 1, i2 + 1)

  c1 = find_LCS_length_recursive(s1, s2, i1, i2 + 1)
  c2 = find_LCS_length_recursive(s1, s2, i1 + 1, i2)

  return max(c1, c2)


def find_LCS_length_DP(s1, s2):
    dp = [ [ -1 for x in range(len(s2))] for y in range(len(s1))]
    return find_LCS_length_DP_recur(dp, s1, s2, 0, 0)


def find_LCS_length_DP_recur(dp, s1, s2, i1, i2):
    if i1 == len(s1) or i2 == len(s2):
        return 0

    if dp[i1][i2] == -1:
        if s1[i1] == s2[i2]:
            dp[i1][i2] = 1 + find_LCS_length_DP_recur(dp, s1, s2, i1 +1 , i2 +1)
        else:
            c1 = find_LCS_length_DP_recur(dp, s1, s2, i1 + 1, i2)
            c2 = find_LCS_length_DP_recur(dp, s1, s2, i1, i2+1)

            dp[i1][i2] = max(c1, c2)
    
    return dp[i1][i2]

def main():
  print(find_LCS_length("abdca", "cbda"))
  print(find_LCS_length("passport", "ppsspt"))
  print(find_LCS_length_DP("abdca", "cbda"))
  print(find_LCS_length_DP("passport", "ppsspt"))


main()
