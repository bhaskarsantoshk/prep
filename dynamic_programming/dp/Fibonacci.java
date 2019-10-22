package dynamic_programming.dp;

public class Fibonacci {
    public int fib ( int n){
        if ( n == 1 || n == 2){
            return 1;
        }
        int a = 1;
        int b = 1;
        int c =0;
        int count=3;
        for ( int i= count; i<=n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
