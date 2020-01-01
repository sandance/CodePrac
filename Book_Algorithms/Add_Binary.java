
class Solution {

    public String addBiary(String a, String b) {
        if(a == null || a.isEmpty()) {
            return b;
        }

        if (b == null || b.isEmpty()) {
            return a;
        }

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int Abit;
        int Bbit;

        int carry = 0, result;

        while( i >= 0 || j >= 0 || carry == 1) {
            Abit = (i >= 0) ? Character.getNumericValue(i--) : 0 ;
            Bbit = (j >= 0) ? Character.getNumericValue(j--) : 0 ;
            
            result = Abit ^ Bbit ^ carry;

            carry = ((Abit + Bbit + carry) >= 2) ? 1 : 0;
            sb.append(result);
        }

        return sb.reverse().toString();
    }
}