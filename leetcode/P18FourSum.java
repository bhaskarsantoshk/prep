package leetcode;

import java.util.*;

public class P18FourSum {
    public List<List<Integer>> fourSum(int[] A, int B) {
        Arrays.sort(A);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if ( A == null || A.length < 4){
            return result;
        }
        for ( int i=0; i< A.length; i++){

            for ( int j= i+1; j< A.length; j++){

                int start = j+1;
                int end = A.length-1;

                while ( start < end ){
                    int sum = A[i] + A[j] + A[start] + A[end];

                    if ( sum == B){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(A[i]);
                        list.add(A[j]);
                        list.add(A[start]);
                        list.add(A[end]);
                        if ( !set.contains(list)) {
                            result.add(list);
                            set.add(list);
                        }
                        start ++;
                        end--;

                    }
                    else if ( sum < B){
                        start ++;
                    }
                    else{
                        end--;
                    }
                }
            }
        }
        return result;
    }
}
