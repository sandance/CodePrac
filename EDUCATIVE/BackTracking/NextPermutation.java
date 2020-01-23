class Solution {

    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int [] nums, int start) {
        int end = nums.length -1;
        while(start <= end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
    public void nextPermutation(int[] nums) {

        // hard problem
        /*
        1. Already in decreasing order, no next large permutation
        2. If not, 
            1. Start from the end of the array and find the first pair of numbers
               that breaks the decrementing order
            3. From that index go to the right again, find the element that is closest bigger than this element
            4. swap them
            5. Reverse the right half of this array after this index
        */

        int i = nums.length - 2; // 2nd last element index

        while(i > 0 && nums[i] >= nums[i+1]){
            i--;
        }

        if( i >= 0) {
            j = nums.length - 1;
            // find next element at right which is bigger than nums[i]
            while(j > 0 && nums[j] >= nums[i]) {
                j--;
            } // found the next biggest element greater than nums[i]

            swap(nums, i, j);

        }

        reverse(nums, i + 1);

    }
}