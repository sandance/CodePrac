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