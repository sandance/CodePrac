class Solution {

    public static List<String> combine(String letters, List<String> result) {
        List<String> newResult = new ArrayList<>();

        for (int i = 0; i < letters.length(); i++) {

            for (String str : result) {
                newResult.add(str + letters.charAt(i));
            }
        }

        return newResult;
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        result.add("");

        String[] digit2Letters = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        for (int i = 0; i < digits.length(); i++) {
            // System.out.println(result);
            result = combine(digit2Letters[digits.charAt(i) - '0'], result);

        }

        return result;
    }
}