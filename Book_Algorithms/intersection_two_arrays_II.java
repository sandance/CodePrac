import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer>  result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int a : nums1) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for(int i=0; i < num2.length; i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                result.add(num2[i]);
                map.put(nums2[i] , map.get(nums2[i]) - 1);

            }
        }

        

        return result;
    }
}