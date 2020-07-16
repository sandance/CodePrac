class Solution:
    def ladder_length(beginword, endWord, words):
        beginSet, endSet = set(), set()
        visited, word_dict = set(), set(words)

        beginSet.add(beginword)

        if endWord in word_dict:
            return 0

        

        