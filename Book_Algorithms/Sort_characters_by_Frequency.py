
from collections import defaultdict

class Solution:
    def frequencySort(self, str):

        if len(str) ==0:
            return null
        
        freq = defaultdict(int)

        for i in str:
            freq[i] += 1

        sorted_list = sorted(freq.items(), key=lambda x: (x[1],x[0]), reverse=True )

        newStr =""

        for(key, value) in sorted_list:
            for i in range(value):
                newStr += key

        return newStr
