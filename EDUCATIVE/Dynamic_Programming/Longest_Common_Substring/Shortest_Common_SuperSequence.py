def short_common_sequence(s1, s2):
    #n1, n2 = len(s1), len(s2)

    return short_common_sequence_recur(s1, s2, 0, 0)


def short_common_sequence_recur(s1, s2, i1, i2):
    n1, n2 = len(s1), len(s2)
    if i1 == n1:
        return n2 - i2
    
    if i2 == n2:
        return n1 - i1
    
    if s1[i1] == s2[i2]:
        return 1 + short_common_sequence_recur(s1, s2, i1 +1, i2 + 1)
    
    c1 = 1 + short_common_sequence_recur(s1, s2, i1  + 1, i2)
    c2 = 1 + short_common_sequence_recur(s1, s2, i1, i2 + 1)

    return min(c1, c2)

def main():
  print(short_common_sequence("abcf", "bdcf"))
  print(short_common_sequence("dynamic", "programming"))


main()
