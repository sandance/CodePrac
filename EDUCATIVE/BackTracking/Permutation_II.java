class Solution {
    // https://youtu.be/A3ge2mdQi4g
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return result;

    }

    public static void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }

                used[i] = true;
                tempList.add(nums[i]);
                backTrack(result, tempList, nums, used);
                used[i] = false;
                // if that does not lead to a solution
                tempList.remove(tempList.size() - 1);

                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    // skip the next element
                    ++i;
                }

            }
        }

    }
}