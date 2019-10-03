package amazon.binarysearch;

import java.util.List;

public class MedianofArray {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
         if ( a.size() > b.size() ){
             return findMedianSortedArrays(b, a);
         }
         int x = a.size();
         int y = b.size();

         int start = 0;
         int end = x;
         while ( start < end ){
             int partitionX = ( start + end)/2;
             int partitionY =  (x+y+1)/ 2 - partitionX;
             int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE: a.get(partitionX-1);
             int minRightX = (partitionX == a.size()-1) ? Integer.MAX_VALUE : a.get(partitionX);

             int maxLeftY = ( partitionY == 0 ) ? Integer.MIN_VALUE : b.get(partitionY-1);
             int minRightY = ( partitionY == y ) ? Integer.MAX_VALUE : b.get(partitionY);

             if ( maxLeftX <= minRightY && maxLeftY <= minRightY){
                 if ( (x+y) % 2 == 0){
                     return ((Math.max(maxLeftX, maxLeftY) + Math.max(minRightX, minRightY))/ 2.0);
                 }
                 else{
                     return Math.max(maxLeftX, minRightY);
                 }
             }
             else if ( maxLeftX < minRightY ){
                 end = partitionX-1;
             }
             else{
                 start = partitionX+1;
             }
         }
         return -1;
    }
}
