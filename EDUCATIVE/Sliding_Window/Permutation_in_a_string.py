from collections import defaultdict

def find_permutation(str, pattern):
    char_freq = defaultdict(int)
    window_start  = 0
    matched = 0

    for char in pattern:
        char_freq[char] += 1

    for window_end in range(len(str)):
        right_char = str[window_end]
        if right_char in char_freq:
            char_freq[right_char] -= 1
            if char_freq[right_char] == 0:
                matched += 1
        
        if matched == len(char_freq):
            return True
        
        if window_end >= len(pattern) - 1:
            left_char = str[window_start]
            window_start += 1
            if left_char in char_freq:
                if char_freq[left_char] == 0:
                    matched -= 1
                char_freq[left_char] += 1
    
    return False
        




    
    
