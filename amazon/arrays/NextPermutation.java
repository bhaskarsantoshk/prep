package amazon.arrays;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.swap;

public class NextPermutation {
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        if ( A== null || A.size() <=1 ) return A;
        int index1 = A.size()-2;
        while ( index1 >= 0 && A.get(index1) >= A.get(index1+1)) index1--;
        if ( index1 >= 0){
            // 1 2 3 4 5 4 3 2 1
            int index2 = A.size()-1;
            while ( A.get(index2) <= A.get(index1)) index2--;
            swap(A, index1, index2);
        }
        reverse(A, index1+1, A.size()-1);
        return A;
    }

    private void reverse(ArrayList<Integer> a, int start, int end) {
        while ( start < end){
            swap(a, start++, end--);
        }
    }
}
