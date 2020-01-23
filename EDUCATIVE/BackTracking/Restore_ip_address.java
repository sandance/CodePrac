import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {

       List<String>  result = new ArrayList<>();
       if(s == null || s.length() > 12 || s.length() < 4) {
           return result;
       } 

       backTrack(result, new ArrayList<String>(), s, 0);
       return result;

    }

    private static boolean isValid(String oneByte) {
        if(oneByte.charAt(0) == '0' && oneByte.length() > 1) {
            return false;
        }
        int num = Integer.valueOf(oneByte);
        return (num >= 0 &&  num < 256);
    }

    public static void backTrack(List<String> result, List<String> tempList, String s, int pos) {
        if (tempList.size() == 4) {
            // one 
            if( pos != s.length()) {
                return;  // go back , it is not the end of the string
            }

            // if it is the end of string
            StringBuilder sb = new StringBuilder();

            for(int i=0; i < 4; i++) {
                sb.append(tempList.get(i));
                System.out.print(tempList.get(i));
                sb.append(".");
            }
            // remove final "." at the end of the string
            sb.setLength(sb.length() - 1);

            result.add(sb.toString());
            return;
        }
        // start from any position , loop to 3 position next from that position 
        for(int i = pos; i < pos + 4 && i < s.length() ; i++) {
            String oneByte = s.substring(pos, i + 1);
            if(!isValid(oneByte)) {
                continue;
            } 
            tempList.add(oneByte);
            backTrack(result, tempList, s, i + 1);
            tempList.remove(tempList.size() - 1);
        }

    }
}