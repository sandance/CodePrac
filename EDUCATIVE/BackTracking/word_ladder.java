import java.util.HashSet;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);

        int len = 1;

        beginSet.add(beginWord);

        if (!dict.contains(endWord)) {
            return 0;

        }

        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            Set<String> nextBeginSet = new HashSet<>();

            for (String word : beginSet) {
                char[] char_words = word.toCharArray();
                for (int i = 0; i < char_words.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = char_words[i];
                        char_words[i] = c;

                        String newWord = new String(char_words);

                        if (endSet.contains(newWord)) {
                            return len + 1;
                        }

                        if (!visited.contains(newWord) && dict.contains(newWord)) {
                            visited.add(newWord);
                            nextBeginSet.add(newWord);
                        }

                        char_words[i] = old;
                    }
                }
            }

            beginSet = nextBeginSet;
            len++;
        }

        return 0;

    }
}