import java.util.HashSet;

class Solution {
    public String reverseVowels(String s) {

        HashSet<Character> vowels = new HashSet<>();
        char [] array = {'a' ,'e', 'i', 'o', 'u'};
        for (char c : array) {
            vowels.add(c);
        }
        //return new StringBuilder(arr.toString());

        StringBuilder stringBuilder = new StringBuilder();

        int start =0;
        int end = s.length() -1;

        while(start < end) {
            char left = s.charAt(start);
            char right = s.charAt(end);

            while(start < end && !vowels.contains(left) ) {
                start++;
                left = s.charAt(start);
            }

            while(start < end && !vowels.contains(right)) {
                end--;
                right = s.charAt(end);
            }

            char temp = left;
            stringBuilder.setCharAt(start, right);
            stringBuilder.setCharAt(end, temp);
            start++;
            end--;


        }

        return stringBuilder.toString();
        
    }
}