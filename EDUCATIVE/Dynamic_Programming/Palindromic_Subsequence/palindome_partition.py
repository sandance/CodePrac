def find_MPP_cuts(st):
    return find_MPP_cuts_recur(st, 0, 0)

def isPalindrome(st, x, y):
    while (x < y):
        if st[x] != st[y]:
            return False
        x = x  + 1
        y = y + 1

def find_MPP_cuts_recur(st, startIndex, endIndex):
    # if whole string is a palindrome , then no cut required
    if startIndex >= endIndex  and isPalindrome(st, startIndex, endIndex):
        return 0

    minimumCuts = endIndex - startIndex
    
    for i in range(endIndex):
        if isPalindrome(st, startIndex, i):
            minimumCuts = min(minimumCuts , 1 + find_MPP_cuts_recur(st, i+1, endIndex ))
        
        return minimumCuts

        
        
def main():
  print(find_MPP_cuts("abdbca"))
  print(find_MPP_cuts("cdpdd"))
  print(find_MPP_cuts("pqr"))
  print(find_MPP_cuts("pp"))
  print(find_MPP_cuts("madam"))


main()