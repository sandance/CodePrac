def find_LPS_length(st):
    dp = [ [-1 for i in range(len(st))] for j in range(len(st))]
    return find_LPS_length_memo(dp, st, 0, len(st) -1)

def find_LPS_length_memo(dp, st, startIndex, endIndex):
    if startIndex > endIndex:
        return 0
    #each character is a palindrome of itself
    if startIndex == endIndex:
        return 1

    if dp[startIndex][endIndex] == -1:
        #step 1 check if they are the same
        if st[startIndex] == st[endIndex]:
            remainLength = endIndex - startIndex -1
            if remainLength == find_LPS_length_memo(dp, st, startIndex + 1, endIndex -1):
                dp[startIndex][endIndex] = remainLength + 2
                return dp[startIndex][endIndex]

        #else
        c1  = find_LPS_length_memo(dp, st, startIndex +  1, endIndex)
        c2 = find_LPS_length_memo(dp, st, startIndex, endIndex -1)
        dp[startIndex][endIndex] = max(c1, c2)

    return dp[startIndex][endIndex]


def main():
  print(find_LPS_length("abdbca"))
  print(find_LPS_length("cddpd"))
  print(find_LPS_length("pqr"))

main()