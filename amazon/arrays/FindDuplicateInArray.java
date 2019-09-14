package amazon.arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateInArray {
    public int repeatedNumber(final List<Integer> a) {
       Set<Integer> set = new HashSet<>();
       for ( Integer num :  a){
           if ( set.contains(num)){
               return num;
           }
           set.add( num);
       }
       return -1;
    }

    // Space Optimized
    public int repeatedNumber2(final List<Integer> a) {
        if ( a == null || a.size() == 0 || a.size() == 1) return -1;
        int slow = 0;
        int fast = 0;
        do{
            slow = a.get(slow);
            fast = a.get(a.get(fast));
        }while ( slow != fast );
        slow = 0;
        while ( slow != fast ){
            slow = a.get(slow);
            fast = a.get(fast);
        }
        return slow;
    }
}
