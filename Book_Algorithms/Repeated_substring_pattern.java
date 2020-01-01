class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int len = s.length();

        for(int i=len/2; i >= 1; i--) {
            if (len % i == 0) {
                int m = len / i;

                String subs = s.substring(0, i);
                StringBuilder stringBuilder = new StringBuilder();

                for(int j=0; j <m; j++) {
                    stringBuilder.append(subs);
                }

                if (stringBuilder.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    
    }
}