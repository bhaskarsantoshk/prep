package amazon.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MatrixMedian {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int r = A.size();
        int c = A.get(0).size();
        for ( int row = 0; row <A.size(); row++ ){
            max = Math.max ( A.get(row).get(c-1), max);
            min = Math.min ( A.get(row).get(0), min);
        }
        int desired = ( r * c + 1 )/2;
        while ( min < max ){
            int mid = min + (max - min)/2;
            int place = 0;
            int get = 0;

            for ( int i=0; i<r; i++) {
                get = (int) Collections.binarySearch(A.get(i), mid);
                if ( get < 0){
                    get = Math.abs ( get) -1;
                }
                else {
                    while ( get < c && A.get(i).get(get) == mid){
                        get++;
                    }
                }
                place = place+ get;
            }
            if ( place < desired ){
                min = mid+1;
            }
            else{
                max = mid;
            }
        }
        return min;
    }
}
