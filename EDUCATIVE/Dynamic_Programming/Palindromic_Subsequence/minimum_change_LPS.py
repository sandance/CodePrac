def minimum_change_LPS(st):
    n = len(st)
    dp = [[ -1 for x in range(n)] for y in range(n)]
    lps = longest_palindrome_subsequence(dp, st, 0, len(st) - 1)
    return len(st) - lps


def longest_palindrome_subsequence(dp, st, startIndex, endIndex):
    if startIndex > endIndex:
        return 0
    
    if startIndex == endIndex:
        return 1

    if dp[startIndex][endIndex] == -1:
        if st[startIndex] == st[endIndex]:
            dp[startIndex][endIndex] = 2 + longest_palindrome_subsequence(dp, st, startIndex + 1, endIndex -1)
        else:
            c1 = longest_palindrome_subsequence(dp, st, startIndex + 1, endIndex)
            c2 = longest_palindrome_subsequence(dp, st, startIndex, endIndex -1)

            dp[startIndex][endIndex] = max(c1, c2)
    return dp[startIndex][endIndex]




def main():
    print(minimum_change_LPS("cddpd"))

main()

