package microsoft.dynamic_programming;

import java.util.List;

public class MaxProductSubarray {
    public int maxProduct(final List<Integer> A) {
        if ( A == null || A.size() == 0){
            return 0;
        }
        int min  = A.get(0);
        int max = A.get(0);
        int maxProd = A.get(0);
        for ( int i=1; i<A.size(); i++){
            if ( A.get(i) < 0){
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min ( min * A.get(i) , A.get(i));
            max = Math.max ( max * A.get(i), A.get(i));
            maxProd = Math.max ( maxProd, max);
        }
        return maxProd;
    }
}
