package dynamic_programming.overlapping_sub_problems;

public class Example_4_1_Fibonacci {
    public int fib( int n){
        if ( n == 1 || n == 2){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public int fibIterative( int n){
        if ( n == 1 || n == 2){
            return 1;
        }
        int a = 1, b=1, c=0;
        int count = 3;
        for ( count =3; count<=n; count++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}
