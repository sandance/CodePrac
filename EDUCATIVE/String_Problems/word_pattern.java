import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String str) {

        String [] words = str.split(" ");

        if(words.length != str.length()) 
            return false;
        
        Map<Character, String> index = new HashMap<>();

        for(int i=0; i < words.length; i++) {
           if(index.containsKey(pattern.charAt(i))){
               //System.out.print(index.get(pattern.charAt(i)));
                if (!index.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
           } else {
               if(map.containsValue(words[i])) {
                   return false;
               }
               index.put(pattern.charAt(i), words[i]);
               System.out.print(index.get(pattern.charAt(i)));
           }
           index.put(pattern.charAt(i), words[i]);
           //System.out.print(index.get(pattern.charAt(i)));
            
           
        }
        return true;
    }
}



