from collections import defaultdict

def permutation_string(str):
    if len(str) == 0:
        return "Input String is empty"
    char_frequency = defaultdict(int)
    for char in str:
        char_frequency[char] += 1

    no_of_odd_chars = 0
    for val in char_frequency.values():
        if val % 2 == 1:
            no_of_odd_chars += 1

    if no_of_odd_chars <= 1:
        return True

    return False


print permutation_string("code")
print permutation_string("aab")
print permutation_string("carerac")
print permutation_string("codella")