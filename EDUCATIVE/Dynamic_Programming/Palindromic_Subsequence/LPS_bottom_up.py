def LPS_bottom_up(st):
    n = len(st)
    dp = [[ False for x in range(n)] for y in range(n)]

    for i in range(n):
        dp[i][i] = True
        
    maxLen = 1
    for startIndex in range(n-1,-1,-1):
        for endIndex in range(startIndex+1, n):
            if st[startIndex] == st[endIndex]:
                    if endIndex - startIndex == 1 or dp[startIndex+1][endIndex-1]:
                        dp[startIndex][endIndex] = True
                        maxLen = max(maxLen, endIndex - startIndex +1)
    return maxLen



def main():
  print(LPS_bottom_up("abdbca"))
  print(LPS_bottom_up("cddpd"))
  print(LPS_bottom_up("pqr"))


main()


                    

