

from collections import defaultdict

def frequencySort(str):
    if str.length == 0:
        return ""

    freq = defaultdict(int)

    for c in str:
        freq[c] += 1

    list = sorted(freq, key=lambda x : (x[1], x[0]))

     newStr =""

    for (key, value ) in list:
        for i in range(value):
            newStr +=key

    return newStr

