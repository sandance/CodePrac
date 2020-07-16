def edit_distance_bottom(str1, str2):
    n1, n2 = len(str1), len(str2)

    dp = [ [ 0 for _ in range(n2 + 1)] for _ in range(n1 + 1) ]

    #if str2 empty, we remove all the chars from st1 to make it empty
    for i in range(n1 + 1):
        dp[i][0] = i
    # if str1 is empty, we remove all the chars from str2
    for i in range(n2 + 1):
        dp[0][i] = i


    for i in range(1, n1+1):
        for j in range(1, n2+1):
            if str1[i-1] == str2[j-1]:
                dp[i][j] = dp[i-1][j-1]
            else:
                dp[i][j] = min(1 + dp[i-1][j-1], min(1+dp[i][j-1], 1+ dp[i-1][j]))
    
    return dp[i][j]


def main():
  print(edit_distance_bottom("bat", "but"))
  print(edit_distance_bottom("abdca", "cbda"))
  print(edit_distance_bottom("passpot", "ppsspqrt"))


main()
