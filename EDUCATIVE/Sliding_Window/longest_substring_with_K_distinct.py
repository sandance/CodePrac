def longest_substring_with_k_distinct(arr, K):
    windowStart = 0
    max_length = 0
    char_frequency = {}

    for windowEnd in range(len(arr)):
        right_char = arr[windowEnd]
        if right_char not in char_frequency:
            char_frequency[right_char] = 0
        char_frequency[right_char] += 1

        #shrink until we are left with k distinct
        while len(char_frequency) > K:
            left_char = arr[windowStart]
            char_frequency[left_char] -= 1
            if char_frequency[left_char] == 0:
                del char_frequency[left_char]

            windowStart += 1
        #remainder minimum length so far
        max_length = max(max_length, windowEnd - windowStart + 1)
    return max_length

def main():    
    print("Length of the longest substring: " + str(longest_substring_with_k_distinct("araaci", 2)))
    print("Length of the longest substring: " + str(longest_substring_with_k_distinct("araaci", 1)))
    print("Length of the longest substring: " + str(longest_substring_with_k_distinct("cbbebi", 3)))


main()