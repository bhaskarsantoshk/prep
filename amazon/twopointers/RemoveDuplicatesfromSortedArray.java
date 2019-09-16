package amazon.twopointers;

import java.util.ArrayList;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(ArrayList<Integer> a) {
       if ( a == null || a.size()== 0){
           return 0;
       }
       int index = 0;
       a.set(index++, a.get(0));
       for ( int i=1; i<a.size(); i++){
           if ( !a.get(index-1).equals(a.get(i))){
               a.set(index++, a.get(i));
           }
       }
       return index;
    }
}
