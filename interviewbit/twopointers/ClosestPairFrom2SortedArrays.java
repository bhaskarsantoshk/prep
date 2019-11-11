package interviewbit.twopointers;

import java.util.ArrayList;

public class ClosestPairFrom2SortedArrays {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int end = B.size()-1;
        int min_diff = Integer.MAX_VALUE;
        int prev_start = -1, prev_end = B.size();
        while ( start < A.size() && end >= 0){
            int sum = A.get(start) + B.get(end);
            int diff = Math.abs(C - sum);
            if ( diff < min_diff || (diff <= min_diff && prev_start >= start && prev_end != end  )){
                min_diff = diff;
                prev_end = end;
                prev_start = start;
            }
            if ( sum > C){
                end--;
            }
            else if ( sum < C){
               start++;
            }
            else{
                min_diff = 0;
                break;
            }
        }
        result.add(A.get(prev_start));
        result.add(B.get(prev_end));
        return result;
    }
}
