from collections import defaultdict

def length_of_longest_substring(arr, k):
    window_start = 0
    maxLen = 0
    char_freq = defaultdict(int)
    max_ones_count = 0

    for window_end in range(len(arr)):
        right_char = arr[window_end]
        if right_char == 1:
            max_ones_count += 1

        

        if window_end - window_start + 1 - max_ones_count > k:
            if arr[window_start] == 1:
              max_ones_count -= 1  
            window_start += 1
            
        maxLen = max(maxLen, window_end - window_start + 1)
    return maxLen


def main():
  print(length_of_longest_substring([0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], 2))
  print(length_of_longest_substring(
    [0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], 3))


main()