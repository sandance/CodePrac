import java.io.*;


public class Solution {

    public static String convert(String s, int numRows) {

        if (s == null || s.length() == 0) {
            return "";

        }

        char[] c = s.toCharArray();
        int len = s.length();

        StringBuffer[] sb = new StringBuffer[numRows];

        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }

        int i = 0;

        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) {
                sb[idx].append(c[i++]);
            }

            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                System.out.println("idx: "+ idx + "character: " + c[i]);
                sb[idx].append(c[i++]);
                //System.out.println("idx: "+ idx + "character: " + c[i]);
            }

        }

        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);
        }

        return sb[0].toString();
    }




        public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();


        System.out.println("Enter the target string");
        String target = sc.next();
        int nRows = sc.nextInt();

        System.out.println("Zigzag conversion:  " +  convert(target, nRows));



    }
}
