import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        
        if(s.length() != t.length())
            return false;
        
        for(int i=0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)).equals(t.charAt(i)) {
                    continue;
                } else {
                    return false;
                }
            } else if (map.get(t.charAt(i)).equals(s.charAt(i))) {
                return false;

            }
            else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
        
    }
}