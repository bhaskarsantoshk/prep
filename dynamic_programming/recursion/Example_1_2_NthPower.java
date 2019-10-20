package dynamic_programming.recursion;

public class Example_1_2_NthPower {
    public int power(int x, int n){
        if ( n == 0 ) return 1;
        if ( n == 1) return n;
        return x * power(x, n-1);
    }
}
