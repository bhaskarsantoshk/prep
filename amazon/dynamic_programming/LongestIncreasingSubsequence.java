package amazon.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lis(final List<Integer> A) {
        int memo[] = new int[A.size()];
        return lis(A, 0, A.size(), Integer.MIN_VALUE);
    }

    private int lis(List<Integer> a, int index, int size, int prev) {
        if ( index == size ) return 0;
        int excl = lis(a, index+1, size, prev);
        int incl = 0;
        if ( a.get(index) > prev ){
            incl= 1+ lis(a, index+1, size, a.get(index));
        }
        return Math.max ( incl, excl);
    }


}
