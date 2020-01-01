import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength  = 0;
        HashSet<String> set = new HashSet<>();

        int i=0,j=0;

        while( j < s.length()) {
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
                System.out.println(s.charAt(j) + "  maxLength : "+ maxLength +" j : " + j + " i :" + i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0)
            return 0;
        
        int [] charMap = new int [26];
        int start =0;
        int end;
        int count = 0;
        

        for(int end=0; end < s.length(); end++) {
            charMap[s.charAt(end) - 'a']++;
        }

        for(int start=0; start < s.length(); start ++) {
            if(charMap[s.charAt[start] -'a']-- > 1) {
                start++;

            }
            
        }

        return s.substring(start, end);

        // now move start pointer
    }
}

































