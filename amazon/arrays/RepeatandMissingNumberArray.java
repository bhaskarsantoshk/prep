package amazon.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepeatandMissingNumberArray {
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int xor = 0;
        for ( int num: A){
            xor ^= num;
        }
        for ( int i=1; i<=A.size(); i++){
            xor ^= i;
        }
        Integer first = 0;
        Integer second = 0;
        int bit= 0;
        int temp = xor;
        while ( (temp & (1<<bit)) == 0){
            bit++;
        }
        for ( int i=1; i<=A.size(); i++){
            if ( (i & (1<<bit))==0){
                first^=i;
            }
            else{
                second^=i;
            }
        }
        for ( int num: A){
            if ( ( num & (1<<bit)) == 0){
                first ^=num;
            }
            else{
                second^=num;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for ( Integer num: A){
            if ( num.equals(first)){
                result.add(first);
                result.add(second);
                return result;
            }
            else if ( num.equals(second)){
                result.add(second);
                result.add(first);
                return result;
            }
        }
        return result;
    }
}
