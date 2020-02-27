import java.util.ArrayList;
import java.util.Arrays;

import java.io.*;


class Solution {

  public List<Integer> findAnagrams(String s, String p) {
      List<Integer> result = new ArrayList<>();

      for(int i=0; i <= s.length() - p.length(); i++) {

        if(isAnagram(s.substring(i, i+ p.length(), p))) {
            result.add(i);
        }

      }
      return result;


  }


  private boolean isAnagram(String s, String p) {
      int [] c = new int [26];

      for(int i=0; i < s.length(); i++) {
          c[s.charAt(i) - 'a']++;
          c[p.charAt(i) - 'a']--;
      }

      for( int i : c) {
          if( i != 0) {
              return false;
          }
      }

      return true;
  }
}