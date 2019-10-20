package dynamic_programming.recursion;

public class Q_1_1_Factorial {
    public int factorial( int n){
        if ( n < 0) return -1;
        if ( n == 0 || n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }
    // Non recursive
    public int fact(int n){
        if ( n < 0) return -1;
        int fact = 1;
        for ( int i=1; i<=n; i++){
            fact*= i;
        }
        return fact;
    }
}
