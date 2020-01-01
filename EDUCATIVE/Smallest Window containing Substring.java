import java.util.*;

    public static String Smallest_Substring (String str, String pattern) {
        int windowStart = 0;
        int matched = 0;
        int minLength = str.length();
        
        int subStrStart = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for( char ch : pattern.toCharArray() ) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for(windowEnd =0 ; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if(freqMap.containsKey(rightChar)) {
                freqMap.put(rightChar, freqMap.get(rightChar) - 1);
                if(freqMap.get(rightChar) >= 0) {
                    matched++;
                }

            }

            //shrink the window if we can

            while(matched == pattern.length()){
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart;
                }

                char leftChar = str.charAt(windowStart++);
                if(freqMap.containsKey(leftChar)) {
                    if(freqMap.get(leftChar) == 0) {
                        matched--;
                    }
                    freqMap.put(leftChar, freqMap.get(leftChar)  + 1);
                }
            }
        }

    
        return minLength > str.length() ? "" : str.substring(subStrStart , subStrStart + minLength);
    }
}