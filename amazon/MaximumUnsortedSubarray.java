package amazon;

import java.util.ArrayList;

public class MaximumUnsortedSubarray {
    public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for ( int i=1; i<A.size(); i++){
            if ( A.get(i) < A.get(i-1)){
                flag = true;
            }
            if ( flag ){
                min = Math.min ( min,A.get(i));
            }
        }
        flag = false;
        for ( int i=A.size()-2; i >= 0; i--){
            if ( A.get(i) > A.get(i+1)){
                flag = true;
            }
            if ( flag == true){
                max = Math.max ( max, A.get(i));
            }
        }
        int l , r;
        for ( l=0; l<A.size(); l++){
            if ( min < A.get(l)){
                break;
            }
        }
        for ( r = A.size()-1; r>=0; r--){
            if ( max > A.get(r)){
                break;
            }
        }
        if ( r - l < 0){
            result.add(-1);
            return result;
        }
        result.add(l);
        result.add(r);
        return result;
    }

    public static void main(String[] args){
        int a[] = {  1,3,2, 5, 2};
        ArrayList<Integer> al = new ArrayList<>();
        for ( int num: a){
            al.add( num );
        }
        System.out.println(subUnsort(al));
    }
}
