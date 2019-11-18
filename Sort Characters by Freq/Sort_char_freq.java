import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        char [] str = s.toCharArray();

        for (Char c : str) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //convert map into a list

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        //sort the map by freq
        Collections.sort(list, (o1, o2) -> (o2.getValue() - o1.getValue()));

        //Build the String
        StringBuilder newStr = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list) {
            for(int i=0; i < entry.getValue(); i++) {
                newStr.append(entry.getKey());
            }
        }

        return newStr.toString();

        
    }
}