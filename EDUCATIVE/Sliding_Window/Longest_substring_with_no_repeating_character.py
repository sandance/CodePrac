def length_of_largest_substring(str):
    maxLen = 0
    char_set = set()
    window_start, window_end = 0, 0

    while window_end < len(str):
        if str[window_end] not in char_set:
            char_set.add(str[window_end])
            window_end += 1
            maxLen = max(maxLen, window_end - window_start)
        else:
            char_set.remove(str[window_start])
            window_start += 1
    return maxLen

def main():
  print("Length of the longest substring: " + str(length_of_largest_substring("aabccbb")))
  print("Length of the longest substring: " + str(length_of_largest_substring("abbbb")))
  print("Length of the longest substring: " + str(length_of_largest_substring("abccde")))


main()
