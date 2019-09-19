package amazon.twopointers;

import java.util.ArrayList;

public class RemoveElementfromArray {
    public int removeElement(ArrayList<Integer> a, int b) {
        int index = 0;
        for ( int i=0; i<a.size(); i++){
            if ( !a.get(i).equals(b)){
                a.set(index++, a.get(i));
            }
        }
        return index;
    }
}
