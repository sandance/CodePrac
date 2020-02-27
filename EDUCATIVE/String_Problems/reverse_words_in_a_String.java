
class Solution {
    public static String reverseWords(String s) {
        if (s == null) return null;
        
        char [] array = s.toCharArray();
        int n = array.length;

        // step reverse the whole string
        reverse(array, 0, n -1);
        // step 2: reverse each word
        reverseWords(array, n);

        for(int i=0; i < array.length; i++) {
            System.out.print(array[i]);
        }

        // clean up spaces
        return cleanSpaces(array, n);
    }

    public static void reverse(char [] a, int i, int j) {
        while(i < j) {
            char temp = a[i];
            a[i++] = a[j];
            a[j--] = temp;
        }
    }
    
    public static void reverseWords(char [] a, int n) {
        int i = 0;
        int j = 0;

        while( i < n) {
            while( i < j || i < n && a[i] == ' ') i++;
            while( j > i || j < n && a[j] == ' ') j--;
            reverse(a, i, j - 1);
        } 
    }

    public static String cleanSpaces(char [] a, int n) {

        int i =0; 
        int j =0;

        while(j < n) {
            while(j < n && a[j] == ' ') j++;
            while(j < n && a[j] != ' ') a[i++] = a[j--];
            while(j < n && a[j] == ' ') j++;

            if (j < n) a[i++] = ' ';
        }

        return new String(a).substring(0, i);
    }

    public static void main(String[] args ) {
        Scanner sc = new Scanner();

        System.out.println("Enter new String");
        String str = sc.next();

        reverseWords(str);


    }


}
