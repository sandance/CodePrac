import java.rmi.Remote;

class Solution {
    private static String remDuplicates(String text) {
        if (text.length() == 1) {
            return text;
        }

        if(text.substring(0, 1).equals(text.subSequence(1,2))) {
            return remDuplicates(text.substring(1));
        } else {
            return text.substring(0,1) + remDuplicates(text.substring(1));
        }
        
    }
}


