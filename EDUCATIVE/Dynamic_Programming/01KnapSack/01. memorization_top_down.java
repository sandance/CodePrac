

class Fibonacci {

    public static int CalculateFibonacci(int n) {
        int [] memorize = new int [n+1];

        return CalculateFibonacciRecursive(memorize, n);
    }

    /*
     * in memoization, we do it top-down in the sense that we solve the top problem
     * first (which typically recurses down to solve the sub-problems)
     */

    public static  int CalculateFibonacciRecursive (int [] memorize, int n) {
        if (n < 2) {
            return n;
        }

        if (memorize[n] != 0) {
            return memorize[n];
        }

        memorize[n] = CalculateFibonacci(n-1) + CalculateFibonacci(n-2); // overlapping subproblems
        return memorize;
    }

    public static void main(String[] args) {
    Fibonacci fib = new Fibonacci();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
  }

}


