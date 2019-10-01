package amazon.math;

public class PowerOfTwoIntegers {
    public int isPower(int A) {
        if ( A == 1) return 1;
        for ( int i=2; i<=A/i; i++){
           int p = A;
           while ( p%i == 0){
               p/=i;
           }
           if ( p == 1) return 1;
        }
        return 0;
    }


}
