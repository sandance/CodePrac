import java.util.*;

class MaxFruitCountOf2Types {
  
    public static int findLength(char[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int windowStart =0 , maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int windowEnd=0; windowEnd < arr.length; windowEnd++) {
            char rightChar = arr[windowEnd];
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while(map.size() == 2) {
                char leftChar = arr[windowStart];
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
            }


            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);

        }
        return maxLen;
    }
}
