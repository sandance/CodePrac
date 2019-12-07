class Solution {
    public int trap(int[] height) {
        if(height == 0) {
            return 0;
        }

        int left =0, right = height.length -1;
        int leftMax = 0, rightMax =0;
        int total_water = 0;

        while(left < right ) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax < rightMax) {
                total_water += (leftMax - height[left]);
                left++;
            } else {
                total_water += (rightMax - height[right]);
                right--;
            }
        }
        return total_water;
    }
}