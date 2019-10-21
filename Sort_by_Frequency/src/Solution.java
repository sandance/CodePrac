import java.io.*;
import java.util.HashMap;
import java.util.*;

public class Solution {

    public static String sort_by_frequency(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for ( Character c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c,0) + 1);
        }

        //got the map

        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(freq.entrySet());

        Collections.sort(list, (o1,o2) -> (o2.getValue() - o1.getValue()));

        System.out.println("List: " + list);

        StringBuilder newStr = new StringBuilder();

        for(Map.Entry<Character, Integer> entry : list) {
            for(int i=0; i < entry.getValue(); i++) {
                newStr.append(entry.getKey());
            }
        }

        return newStr.toString();

    }


    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter String");
        String str = sc.next();

        System.out.println("Search Index: " +  sort_by_frequency(str));



    }
}
