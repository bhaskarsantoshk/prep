package amazon.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();
        Collections.sort(a);
        backtrack( result, a, new ArrayList<>(), b, 0, set);
        return result;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> nums, ArrayList<Integer> tempList, int remain, int start, Set<ArrayList<Integer>> set) {
        if ( remain < 0 ){
            return;
        }
        else if ( remain == 0 ){
            if ( !set.contains(tempList)) {
                result.add(new ArrayList<>(tempList));
                set.add(tempList);
            }
        }
        else{
            for ( int i = start ; i< nums.size(); i++ ){
                tempList.add(nums.get(i));
                backtrack(result, nums, tempList, remain-nums.get(i), i+1, set);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
