package amazon.arrays;

import java.util.ArrayList;

public class FirstMissingInteger {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int size = moveNegativeNumbers(A);
        return firstMissingPositive(A, size)
    }

    private int firstMissingPositive(ArrayList<Integer> a, int size) {
        for ( int i=0; i<size; i++){
            int x = Math.abs(a.get(i));
            if ( x-1 < size && a.get(x-1) >0){
                a.set(x-1, -1 * a.get(x-1));
            }
        }
        int result = size+1;
        for ( int i=0; i<size; i++){
            if ( a.get(i) >0 ){
                result = i+1;
                break;
            }
        }
        return result;
    }

    private int moveNegativeNumbers(ArrayList<Integer> a) {
        int index = 0;
        for ( int i=0; i<a.size(); i++){
            if ( a.get(i) > 0){
                a.set(index++, a.get(i));
            }
        }
        return index;
    }
}
