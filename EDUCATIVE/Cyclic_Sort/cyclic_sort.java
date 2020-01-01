

class Solution {

    public static void cylic_sort(int [] nums) {
        for (int i=0; i < nums.length; i++) {
            nums[nums[i] - 1] = nums[i];
        }
    }
}