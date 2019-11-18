import java.util.ArrayList;
import java.util.HashMap;
//total time complexity incurred is T O(nk²). Space complexity is S O(n),

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        if (words == null || words.length == 0) {
            return result;
        }

        HashMap<String, Integer> map = new HashMap<>();

       for(int i=0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for(int i =0 ; i < words.length; i++) {
            for(int j=0; j < words[i].length(); j++) {
                String substr1 = words[i].substring(0, j);
                String substr2 = words[i].substring(j);
                
                //System.out.println(substr1 +"\t" + substr2);
                
                if(isPalindrome(substr1)) {
                    String str2rev = new StringBuilder(substr2).reverse().toString();
                    //System.out.print("Palindome:" + str2rev+"\t");
                
                /*
                For each unique word in the words array, consider the word to be divided
                 into two substrings, str1 and str2, with str1 progressively increasing from
                  “” (empty) substring to the entire word while str2 assumes the remaining part
                   of the word. Check if str1 is a palindrome and if so then there is a possibility 
                   of it functioning as the pivot around which a palindrome could be formed.
                   '' In order to determine whether a palindrome could be indeed formed, determine 
                   whether the reverse of the str2 exists within the map and does not correspond to
                    the current index in contention (as is the case in case str2 is “aa” in which
                     case reverse of str2 is also “aa” and hence can correspond to the current 
                     index in the map), so as to function as a prefix to form a palindrome with str1
                      as the pivot.
                */
                if(map.containsKey(str2rev) && map.get(str2rev) != i) {
                    List<Integer> list = new ArrayList<>();
                   // System.out.println("Map:" + map.get(str2rev));
                    list.add(map.get(str2rev));
                    list.add(i);
                    result.add(list);
                    }
                    
                
                } // if closeshere

                /*
                 If the reversed string is indeed present in the map and does not correspond to
                 the current index, then you have got one pair of palindromes that can be added 
                 to the result list of lists. Create a temporary list, and add the prefix reversed
                 string’s index to the temp list first, followed by current index i and add the temp 
                 list to the resultant list of lists
                */
                
                if (isPalindrome(substr2)) {
                    String str1rev = new StringBuilder(substr1).reverse().toString();
                    
                    if(map.containsKey(str1rev) && map.get(str1rev)  != i 
                      && substr2.length() != 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(str1rev));
                        list.add(i);
                        result.add(list);
                        
                    }
                }
                
            
        }
        }

        return result;
    }
    
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        
        while(left <= right) {
            if(str.charAt(left++) != str.charAt(right--)){
                return false;
            }
        }
        return true;
        
    }
}