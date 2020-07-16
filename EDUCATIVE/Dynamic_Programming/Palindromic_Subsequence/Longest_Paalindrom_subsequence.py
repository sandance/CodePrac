

def find_longest_palindrome_subsequence(st):
    dp = [ [ -1 for _ in range(len(st))] for y in range(len(st))]
    return find_LPS_memo(dp, st, 0, len(st) - 1)


def find_LPS_memo(dp, st, startIndex, endIndex):
    # every sequence with onee element is a palindrome of length 1
    if startIndex > endIndex:
        return 0

    if startIndex == endIndex:
        return 1
    
    if dp[startIndex][endIndex]  == -1:
        if st[startIndex] == st[endIndex]:
            return 2 + find_LPS_memo(dp, st, startIndex + 1 , endIndex -1)
        
        else:
            c1 = find_LPS_memo(dp, st, startIndex + 1 , endIndex)
            c2 = find_LPS_memo(dp, st, startIndex, endIndex - 1)
            dp[startIndex][endIndex] = max(c1, c2)
    
    return dp[startIndex][endIndex]



def main():
  print(find_longest_palindrome_subsequence("abdbca"))
  print(find_longest_palindrome_subsequence("cddpd"))
  print(find_longest_palindrome_subsequence("pqr"))


main()

    
