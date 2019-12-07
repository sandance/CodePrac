class Solution {
    public String convert(String s, int numRows) {

        if (s==null || s.length() == 0) {
            return "";

        }

        StringBuilder result = new StringBuilder();

        for(int i=0; i < s.length(); i++) {
            for(int j=i; j <s.length(); j=i+numRows) {
                result.append(s.charAt(j));
            }
            //result.

        }
        return result.toString();
        
    }
}