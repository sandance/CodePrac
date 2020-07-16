from collections import defaultdict

def find_string_anagram(str, pattern):
    window_start = 0
    matched = 0
    char_freq = defaultdict(int)
    result = []

    for char in pattern:
        char_freq[char] += 1

    for window_end in range(len(str)):
        right_char = str[window_end]

        if right_char in char_freq:
            char_freq[right_char] -= 1
            if char_freq[right_char] == 0:
                matched += 1
        
        if matched == len(char_freq):
            result.append(window_start)

        #shrink the window
        if window_end >= len(char_freq):
            left_char = str[window_start]
            window_start += 1
            if left_char in char_freq:
                #matched -= 1
                if char_freq[left_char] == 0:
                    matched -= 1
            char_freq[left_char] += 1
        
    return result

