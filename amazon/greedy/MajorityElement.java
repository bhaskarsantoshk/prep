package amazon.greedy;

import java.util.List;

public class MajorityElement {
    public int majorityElement(final List<Integer> A) {
        int majority_element = A.get(0);
        int count = 1;
        for ( int i=1;  i < A.size(); i++ ){
            if ( majority_element == A.get(i)){
                count++;
            }
            else{
                count--;
                if ( count == 0){
                    majority_element = A.get(i);
                    count = 1;
                }
            }
        }
        return majority_element;
    }
}
