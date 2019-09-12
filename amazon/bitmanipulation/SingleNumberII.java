package amazon.bitmanipulation;

import java.util.List;

public class SingleNumberII {
 /*
    How to check if a number has set bit in ith position
     (num & ( 1 << i)) !=0
    How to set ith position of a number?
     ( num | ( 1 << i) )

    */
    public int singleNumber(final List<Integer> A) {
        int result = 0;
        for ( int i=0; i< 32; i++ ){
            int count = 0;
            for ( Integer num : A){
                if ( ( num & (1 << i)) != 0) {
                    count++;
                }
            }
            result = result | ((count%3) << i);
        }
        return result;
    }
}
