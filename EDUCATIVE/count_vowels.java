import java.util.HashSet;

class solution {
    public static HashSet<Character> set = new HashSet<>();
        char [] arr = {a,e,i,o.u};
        for(char a : arr) {
            set.add(a);
        }

        int count =0;

    public static int count_vowels(String str) {
        
        if (str.length() == 0)
            return 0;
        else if (str.length() == 1 && set.contains(str.charAt(0))) {
            return 1;
        }

        count += count_vowels(str.substring(0,1));

        return count;
    }
}