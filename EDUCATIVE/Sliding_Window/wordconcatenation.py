from collections import defaultdict

def find_word_concatenation(str, words):
    """

    :param str: example "catfoxcat"
    :param words: example ["cat", "fox"]
    :return: []
    """

    if len(words) == 0 or len(words[0]) == 0:
        return []

    word_frequency = defaultdict(int)
    result = []
    for word in words:
        word_frequency[word] += 1

    word_count = len(words)
    word_length = len(words[0])

    for i in range((len(str) - word_count * word_length) + 1):
        word_seen = defaultdict(int)
        for j in range(0, word_count):
            next_word_index = i + j * word_length
            word = str[next_word_index : next_word_index + word_length]
            if word not in word_frequency:
                break

            word_seen[word] += 1

            if word_seen[word] > word_frequency.get(word, 0):
                break

            if j + 1 == word_count:
                result.append(i)

        return result



def main():
  print(find_word_concatenation("catfoxcat", ["cat", "fox"]))
  print(find_word_concatenation("catcatfoxfox", ["cat", "fox"]))


main()



