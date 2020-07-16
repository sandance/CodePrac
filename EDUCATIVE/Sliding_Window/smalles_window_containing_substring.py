from collections import defaultdict
import math

def fine_substring(str, pattern):
    window_start = 0
    minWindow = len(str) + 1
    char_freq = defaultdict(int)
    matched = 0

    for chr in pattern:
        char_freq[chr] += 1
    
    for window_end in range(len(str)):
        right_char = str[window_end]
        if right_char in char_freq:
            char_freq[right_char] -= 1
            if char_freq[right_char] >= 0:
                matched += 1

        while matched == len(char_freq):
            if minWindow > window_end - window_start + 1:
                minWindow = window_end - window_start + 1
                substr_start = window_start
        
            #shrink the window
        
            left_char = str[window_end]
            window_start += 1
            if left_char in char_freq:
                if char_freq[left_char] == 0:
                    matched -= 1
                char_freq[left_char] += 1

    if minWindow > len(str):
        return ""
    return str[substr_start : substr_start + minWindow]



