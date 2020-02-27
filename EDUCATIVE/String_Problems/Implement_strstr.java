

class Solution {

    public int strStr(String haystack, String needle) {
        // bruth force solution

        for(int i=0; i < haystack.length() - needle.length(); i++) {
            for(int j=0; j < needle.length() && haystack.charAt(i + j) == needle.charAt(needle); j++) {
                if ( j == needle.length()) return i; 
            }
        }
        return 0;
    }
}

// using string equals

class Solution1 {
    public int strStr(String haystack, String needle) {
        if (needle.equals(haystack)) return 0;

        int L = needle.length();

        for(int i=0; i <= haystack.length(); i++) {
            if(haystack.substring(i, i+L).equals(needle))
                return i;
        }
        return -1;
    }
}