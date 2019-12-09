package random;

public class Factors {
    public static int getFactorsCount( int n){
        int count =0;
        for ( int i=1; i<= n/i; i++){
            if ( n % i == 0){
                if ( i != n/i) {
                    count+=2;
                }
                else{
                    count++;
                }
            }
        }
        return count;
    }
}
