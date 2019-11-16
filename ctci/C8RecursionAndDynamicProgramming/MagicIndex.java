package ctci.C8RecursionAndDynamicProgramming;

public class MagicIndex {
    int magicSlow( int[] a){
        for ( int i=0; i<a.length; i++){
            if ( a[i] == i){
                return i;
            }
        }
        return -1;
    }

    int magicFast( int[] a){
        return magicFast(a, 0, a.length-1);
    }

    private int magicFast(int[] a, int start, int end) {
        if ( end < start ){
            return -1;
        }
        int mid = ( start + end)/2 ;
        if ( a[mid] == mid ){
            return mid;
        }
        else if ( a[mid] > mid ){
            return magicFast(a, start, mid-1 );
        }
        else{
            return magicFast(a, mid+1, end);
        }
    }

    // If elements are not distinct

    private int magicFastDist ( int[] a, int start, int end){
        if ( start > end ) return -1;
        int midIndex = ( start + end )/2;
        int midValue = a[ midIndex];

        if ( midIndex == midValue){
            return midIndex;
        }
        int leftIndex = Math.min ( midIndex-1, midValue);
        int left = magicFast(a, start, leftIndex);
        if ( left >= 0){
            return left;
        }
        int rightIndex = Math.max ( midIndex+1, midValue);
        int right = magicFast(a, rightIndex, end);
        return right;
    }
}
