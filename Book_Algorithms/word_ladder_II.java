import java.util.*;


class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        Map<String, Integer> ladder = new HashMap<String, Integer>();
        List<List<String>> results = new ArrayList<List<String>>();

        if(wordList.size() == 0)
            return results;

        int min = Integer.MAX_VALUE;

        Queue<String> queue = new ArrayDeque<String>();
        queue.add(beginWord);

        for(String str : wordList) {
            ladder.put(str, Integer.MAX_VALUE);
        }

        ladder.put(beginWord, 0);

        wordList.add(endWord);

        // BFS : Dijisktra Search

        while(!queue.isEmpty()) {

            String word = queue.poll();
            // step indicates how many steps  required to travel to one word

            int step = ladder.get(word) + 1;

            if (step > min) {
                break;
            }

            for(int i =0 ; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);

                for(char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String new_word = builder.toString();

                    if (ladder.containsKey(new_word)) {
                        // check if it is the shortest path to one word
                        if (step > ladder.get(new_word)) {
                            continue;
                        } else if ( step < ladder.get(new_word)) {
                            queue.add(new_word);
                            ladder.put(new_word, step);
                        } else {
                            if(map.containsKey(new_word))
                                map.get(new_word).add(word);
                            else {
                                List<String> list = new ArrayList<>();
                                list.add(word);
                                map.put(new_word, list);
                            }
                        }

                        if(new_word.equals(endWord)) {
                            min = step;
                        }
                    }
                }
            } // 

        } // end while

        // backTracking

        LinkedList<String> result = new LinkedList<>();
        backTrack(endWord, beginWord, result);

        return results;





    }
}