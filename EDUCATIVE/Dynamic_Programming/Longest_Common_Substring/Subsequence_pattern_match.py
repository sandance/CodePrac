def subsequence_pattern(s1, s2):
    return subsequence_pattern_recur(s1, s2, 0, 0)

def subsequence_pattern_recur(str, pat, strIndex, patIndex):
    #If we reached the end of the pattern
    if patIndex == len(pat):
        return 1
    
    #if we reach end of string and pattern has still some character left
    if strIndex == len(str):
        return 0

    c1 = 0
    if (str[strIndex] == pat[patIndex]):
        c1 = subsequence_pattern_recur(str, pat, strIndex + 1, patIndex +1)
    
    c2 = subsequence_pattern_recur(str, pat, strIndex + 1, patIndex)

    return c1 + c2 



def main():
  print(subsequence_pattern("baxmx", "ax"))
  print(subsequence_pattern("tomorrow", "tor"))


main()
    
