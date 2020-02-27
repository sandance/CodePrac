import java.util.*;

class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        //bruth force method

        List<Integer> result = new ArrayList<>();
        if(s== null || words.length == 0) {
            return result;
        }

        /* 
        Algo: create combination of all strings 
        check that with input string */

        int word_length = words[0].length() * words.length;

        if (s.length() < word_length) {
            return result;
        }

        



        return result;
    }
}