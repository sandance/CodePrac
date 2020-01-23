import java.util.ArrayList;
import java.util.List;

class permutationSequence {
    // https://youtu.be/LQXcCbTOE_c
    public static String getPermutation(int n, int k) {

       int pos  = 0;
       List<Integer> numbers = new ArrayList<>();
       int [] factorial = new int [n+1];
       StringBuilder sb = new StringBuilder();

       //create a array of factorial lookup
       int sum = 1;

       factorial[0] = 1;

       for(int i=1; i < n; i++){
           sum *= i;
           factorial[i] = sum; // 1, 2,6,24....
       }

       //create a list of numbers to get indics
       for(int i=1; i <= n; i++) {
           numbers.add(i);
       }

       k--;

       for(int i=1; i <= n; i++) {
           int index = k / factorial[n - i];
           sb.append(String.valueOf(numbers.get(index)));
           numbers.remove(index);
           k -= index * factorial[n-i];

       }

       return String.valueOf(sb);

    }


    public static void main(String[] args) {
        System.out.println(getPermutation(3, 5));
    }
}