from collections import defaultdict

def longest_substring_with_k_distinct(str, k):
    window_start = 0
    max_length = 0
    char_frequency = defaultdict(int)

    # in the following loop we'll try to extend the range [window_start, window_end]
    for window_end in range(len(str)):
        right_char = str[window_end]
        char_frequency[right_char] += 1
    
    #strink the sliding window, until we are left with k distinct characters
    while len(char_frequency) > k:
        left_char = str[window_start]
        char_frequency[left_char] -= 1
        if char_frequency[left_char] == 0:
            del char_frequency[left_char]
        window_start += 1
    #remember the max length so far
    max_length = max(max_length, window_end - window_start + 1)
    return max_length


def main():
  print("Length of the longest substring: " + str(longest_substring_with_k_distinct("araaci", 2)))
  print("Length of the longest substring: " + str(longest_substring_with_k_distinct("araaci", 1)))
  print("Length of the longest substring: " + str(longest_substring_with_k_distinct("cbbebi", 3)))


main()


