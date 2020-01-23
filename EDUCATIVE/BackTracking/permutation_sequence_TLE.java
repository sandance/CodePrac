class Solution {

    /* This Solution gets TLE with 9!" */
    public String getPermutation(int n, int k) {

        // create the permutation string
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        List<List<Character>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), nums);
        Iterator<List<Integer>> iter = result.iterator();
        int counter = 0;
        while (iter.hasNext()) {
            counter++;
            List<Integer> value = iter.next();
            if (counter == k) {
                return value.toString();
            }
        }
        return "";
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i]))
                    continue;
                tempList.add(nums[i]);
                backTrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }

    }
}