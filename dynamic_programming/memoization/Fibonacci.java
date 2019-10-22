package dynamic_programming.memoization;

public class Fibonacci {
    public int fib ( int n){
        int []memo = new int[n+1];
        return fib( memo, n);
    }

    private int fib(int[] memo, int n) {
        if ( memo[n] != 0){
            return memo[n];
        }
        if ( n == 1 || n == 2){
            memo[n] = 1;
        }
        else{
            memo[n] = fib(n-1) + fib(n-2);
        }
        return memo[n];
    }
}
