import java.util.Arrays;

class Solution {
    public static List<List<Integer>> ThreeSum(int [] nums) {
        if (nums == null)
            return null;

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i < nums.length - 3; i++) {
            if( i >= 0 && nums[i-1] == nums[i])
                continue;
            
            for(int j = i + 1; j < nums.length - 2; j++) {
                if ( j > i && nums[j-1] == nums[j] ) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while(left < right) {
                    int sum = nums[i] + nums[j]+ nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left + 1 < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while(right - 1 > right && nums[right -1] == nums[right]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if ( sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            
            }

        }
        return result;
    }
}