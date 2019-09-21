package amazon.arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public String largestNumber(final List<Integer> A) {
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * (String.valueOf(o1)+String.valueOf(o2)).compareTo(String.valueOf(o2)+String.valueOf(o1));
            }
        });
        StringBuilder result = new StringBuilder();
        for ( Integer num: A){
            if ( num == 0 && result.length() != 0){
                continue;
            }
            result.append(String.valueOf(num));
        }
        return result.toString();
    }
}
