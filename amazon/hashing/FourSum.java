package amazon.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        if ( A == null || A.size() < 4){
            return result;
        }
        for ( int i=0; i< A.size()-3; i++){
//            if ( i!= 0 && A.get(i) == A.get(i-1)){
//                continue;
//            }
            for ( int j= i+1; j< A.size()-2; j++){
//                if ( j!= i+1 && A.get(j) == A.get(j+1)){
//                    continue;
//                }
                int start = j+1;
                int end = A.size()-1;

                while ( start < end ){
                    int sum = A.get(i) + A.get(j) + A.get(start) + A.get(end);

                    if ( sum == B){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(A.get(i));
                        list.add(A.get(j));
                        list.add(A.get(start));
                        list.add(A.get(end));
                        if ( !set.contains(list)) {
                            result.add(list);
                            set.add(list);
                        }
                        start ++;
                        end--;

//                        while ( start < end  && A.get(start) == A.get(start-1)){
//                            start++;
//                        }
//                        while ( start < end && A.get(end)== A.get(end+1)){
//                            end--;
//                        }
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
