import java.io.*;


class Solution {
    public static int characterReplacement(String s, int k) {

        int len = s.length();
        int [] count = new int [26];

        int window_start = 0 ;
        int maxCount =0, maxLength = 0;

        for(int window_end =0; window_end < len; window_end++ ) {
            maxCount = Math.max(maxCount, ++count[s.charAt(window_end) - 'A']);

            System.out.println("Window count: " + (window_end - window_start + 1 - maxCount) );
            while(window_end - window_start + 1 - maxCount > k) {
                System.out.println(window_end - window_start + 1 - maxCount);
                count[s.charAt(window_start) - 'A']--;
                window_start++;
            }


            System.out.println("Max count:" + maxCount);
            maxLength = Math.max(maxLength, window_end - window_start + 1);
        }

        return maxLength;
    }


    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter String");
        String str = sc.next();

        System.out.println("Enter K");
        int target = sc.nextInt();

        System.out.println("Longest replacement " + characterReplacement(str, target) );



    }
}


class CharacterReplacement {
    public static int findLength(String str, int k) {
      // TODO: Write your code here

      int windowStart = 0;
      int maxLen = 0;
      int [] char_freq = new int [26];

      for(int windowEnd =0; windowEnd < str.length() ; windowEnd++) {
          maxLen = Math.max(maxLen, ++char_freq[str.charAt(windowEnd) - 'a']);

          while(windowEnd - windowStart + 1 - maxLen > k) {
              char_freq[str.charAt(windowStart)]--;
              windowStart++;
          }
      }
      return windowEnd - windowStart + 1;
    }
  }