from collections import defaultdict
from heapq import *

def sort_character_by_frequency(str):
    freq_str = defaultdict(int)

    for i in str:
        freq_str[i] += 1
    
    maxHeap = []
    for char, freq in freq_str.items():
        heappush(maxHeap, (-freq, char))
    
    sorted_string = []
    
    while maxHeap:
        freq, char = heappop(maxHeap)
        #print ("{0} and {1}".format(freq, char))
        for _ in range(-freq):
            sorted_string.append(char)

    return ''.join(sorted_string)


def main():
    print("String after sorting characters by frequency: " +
        sort_character_by_frequency("Programming"))
    print("String after sorting characters by frequency: " +
        sort_character_by_frequency("abcbab"))

main()