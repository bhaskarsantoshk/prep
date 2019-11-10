package ctci.C16moderate;

public class FactorialZeros {
    public int trailingZeros ( int n ){
        int count = 0;
        if ( n < 0){
            return -1;
        }
        for ( int i =5; n/i > 0; i*= 5){
            count+= n/i;
        }
        return count;
    }
}
