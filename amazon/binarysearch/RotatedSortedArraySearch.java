package amazon.binarysearch;

import java.util.List;

public class RotatedSortedArraySearch {
    public int search(final List<Integer> a, int b) {
        int start = 0;
        int end = a.size()-1;
        while ( start <= end ){
            int mid = (start)+ (end-start)/2;
            if ( a.get(mid) == b){
                return mid;
            }
            else if ( a.get(start) <= a.get(mid)){
                if ( a.get(start) <= b && a.get(mid) > b){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if ( a.get(end) >= b && a.get(mid) < b ){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
