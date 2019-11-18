import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

public class solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String> > result = new ArrayList<>();
        if(strs == null) 
            return result;

        
        HashMap<String, List<String>> map = new HashMap<>();


        for(String s : strs) {
            char [] ca = s.toCharArray();
            Arrays.sort(ca);

            String keyStr = String.valueOf(ca);
            if(!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<String>());
            
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}