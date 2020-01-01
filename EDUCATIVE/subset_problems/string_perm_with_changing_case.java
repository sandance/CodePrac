import java.util.*;

class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        // TODO: Write your code here
        if(str == null) {
            return permutations;
        }

        permutations.add(str);

        for(int i = 0; i < str.length(); i++) {
            // process every character of the string one by one
            if(Character.isLetter(str.charAt(i))) {
                // only process characters, skip digits
                int n = permutations.size();
                System.out.println("Permutation total size: " + n);
                for(int j = 0; j < n; j++) {
                    chars [] chs = permutations.get(j).toCharArray();

                    if (Character.toUpperCase(chs[i])) {
                        chs[i] = Character.toLowerCase(chs[i]);
                    } else {
                        chs[i] = Character.toUpperCase(chs[i]);
                    }

                    permutations.add(String.valueOf(chs));
                }
            }
        }

        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
