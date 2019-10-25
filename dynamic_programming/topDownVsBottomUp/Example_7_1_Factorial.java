package dynamic_programming.topDownVsBottomUp;

public class Example_7_1_Factorial {

    //TopDown
    public int factorial ( int n){
        if ( n == 1 ) return 1;
        return n * factorial(n-1);
    }

    //BottomUp
    public int fact( int n ){
        int fact = 1;
        for ( int i=2; i<=n; i++){
            fact *= i;
        }
        return fact;
    }
}
