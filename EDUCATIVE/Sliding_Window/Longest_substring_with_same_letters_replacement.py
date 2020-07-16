from collections import defaultdict

def length_of_longest_substring(str, k):
      # TODO: Write your code here
    window_start = 0
    maxLen  = 0
    char_freq = defaultdict()
    max_repeted_letter_count = 0

    for window_end in range(len(str)):
        right_char = str[window_end]          
        char_freq[right_char] += 1

        max_repeted_letter_count = max(max_repeted_letter_count, char_freq[right_char])

        if window_end - window_start + 1 - max_repeted_letter_count > k:
            left_char = str[window_start]
            char_freq[left_char] -= 1
            window_start += 1

        maxLen = max(maxLen, window_end - window_start + 1)   
    return maxLen

def main():
  print(length_of_longest_substring("aabccbb", 2))
  print(length_of_longest_substring("abbcb", 1))
  print(length_of_longest_substring("abccde", 1))


main()