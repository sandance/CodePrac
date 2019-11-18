import java.util.HashSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> intersect = new HashSet<>();

        for (int a : nums1) {
            hs.add(a);
        }

        for(int i=0; i < num2.length; i++) {
            if(hs.contains(nums2[i])) {
                intersect.add(i);
            }
        }

        int [] result = new int [intersect.size()];
        int index=0;
        for(Integer num : intersect) {
            result[index++] = num;
        }
        return result;
    }
}