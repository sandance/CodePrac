import java.util.*;

class solution {
    public static boolean palindromeFinder(String str, String pattern) {
        //int windowEnd = 0; 
        int matched = 0;
        HashMap<Character, Interger> map = new HashMap<Character, Integer>();

        for(char chr : pattern.toCharArray()) {
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }

        for(int windowEnd=0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if (map.containsKey(rightChar)) {
                // decrement freq
                map.put(rightChar, map.get(rightChar) -1 );
                if(map.get(rightChar) == 0) {
                    //map.remove(rightChar);
                    matched++;
                }
            }

            if(matched == map.size()) {
                return true;
            }

            if(windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);

                if(map.containsKey(leftChar) == 0) {
                    matched -- ;

                }

                map.put(leftChar, map.get(leftChar)  +1);

            }

            
        }
    } 
}
    