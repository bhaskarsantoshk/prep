package amazon.twopointers;

import java.util.ArrayList;

public class MaxContinuousSeriesOf1s {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int left = 0, right =0;
        int result_left = 0, result_right = 0;
        int zero_count = 0;
        int maxLen = 0;
        for ( right =0; right < A.size(); right++ ){
            if ( A.get(right) == 0){
                zero_count++;
            }
            while ( zero_count > B){
                if ( A.get(left) == 0 ){
                    zero_count--;
                }
                left++;
            }
            if ( right-left +1 > maxLen){
                result_left = left;
                result_right = right;
                maxLen = right - left+1;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for ( int i=result_left; i<= result_right; i++){
            result.add(i);
        }
        return result;
    }
}
