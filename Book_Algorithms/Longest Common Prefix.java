
class solution {
    public static String longestCommonPrefix(String[] strs) {
        StringBuild result = new StringBuilder();

        if(strs.length == 0 || strs == null)
            return result;
        
        //Arrays.sort(strs);
        for(int i=0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(int j=1; j < strs.length; j++) {
                if(i == strs[i].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
       
    }
}