

class target_sum {

    public int findTargetSubsets(int [] nums, int S) {
        int totalSum = 0;
        for(int n : nums) {
            totalSum += n;
        }
        // if (s+totalSum) is odd, we cant find a subset with sum equal to (s + totalSum) /2
        if (totalSum < 0 || (S + totalSum) % 2 == 1) {
            return 0;
        }

        return
    }
}