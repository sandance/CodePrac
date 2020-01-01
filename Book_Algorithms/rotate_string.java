class Solution {


    public static String rotate_string(String str, int offset) {
        if (offset == 0) return str;

        return str.substring(offset) + str.substring(0,offset);
    }

    /*

    abcdef // efabcd
    d=2

    reverseArray(arr, 0, d -1) // ba
    reverseArray(arr, d, n -1) // fedc
    reverseArray(arr, 0, n -1) // ba 


    */

    public boolean rotateString(String A, String B) {
        String new_str = "";
        if (A==null || B==null) {
            return true;
        }

        if(A.length() != B.length()) {
            return false;
        }

        //char [] str = A.toCharArray();

        for(int i=0; i<A.length();i++) {
            new_str = rotate_string(A, i);

            if(B.equals(new_str)) {
                return true;
            }


        }

        return false;
        
    }
}

/* Algo

 Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Algo:

total numnber of elements and do rotation upto n
check each time with other output

*/


