def count_LPS(st):
    return count_LPS_recur(st, 0, len(st) -1)


def count_LPS_recur(st, startIndex, endIndex):
    if startIndex > endIndex:
        return 0

    if startIndex ==  endIndex:
        return 1

    if st[startIndex] == st[endIndex] and endIndex - startIndex == 1:
        remainLength = endIndex - startIndex
        if remainLength == count_LPS_recur(st, startIndex+1, endIndex-1):
            return 1
      
    c1  = count_LPS_recur(st, startIndex +1 , endIndex)
    c2  = count_LPS_recur(st, startIndex, endIndex -1)

    return c1 + c2 

def main():
  print(count_LPS("abdbca"))
  print(count_LPS("cddpd"))
  print(count_LPS("pqr"))
  print(count_LPS("qqq"))


main()