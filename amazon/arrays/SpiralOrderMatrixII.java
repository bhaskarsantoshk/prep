package amazon.arrays;

import java.util.ArrayList;

public class SpiralOrderMatrixII {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int index=1;
        for ( int i=0; i<A; i++){
            result.add(new ArrayList<>());
            for ( int j=0; j<A; j++){
                result.get(i).add(0);
            }
        }
        int flag = 0;
        int top =0, bottom = A-1, left =0, right = A-1;
        while ( top <= bottom && left <= right){
            if ( flag == 0){
                for ( int i=left ; i<=right; i++){
                    result.get(top).set(i, index++);
                }
                flag = 1;
                top++;
            }
            else if ( flag == 1){
                for ( int i= top; i<=bottom; i++){
                    result.get(i).set(right, index++);
                }
                flag = 2;
                right--;
            }
            else if ( flag == 2 ){
               for ( int i=right; i>= left; i--){
                   result.get(bottom).set(i, index++);
               }
               bottom--;
               flag = 3;
            }
            else if ( flag == 3){
                for ( int i=bottom; i>=top; i--){
                    result.get(i).set(left, index++);
                }
                left++;
                flag = 0;
            }
        }
        return result;
    }


}
