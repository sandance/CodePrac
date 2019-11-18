import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return result;
        }

        HashMap<String> visit = new HashMap<>();
        HashMap<String> repeated = new HashMap<>();

        for(int i=0; i + 9 < s.length();i++) {
            substr = s.substring(i, i+9);
            if (!visit.add(substr)) {
                repeated.add(substr);
            }

        }
        return result;   
    }
}