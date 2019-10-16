package amazon.backtracking;

import java.util.*;

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>(A);
        ArrayList<Integer> newList = new ArrayList<>(set);
        Collections.sort(newList);
        backtrack(result, new ArrayList<>(), newList, B, 0);
        return result;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempList, ArrayList<Integer> nums, int remain, int start) {
        if ( remain < 0) return;
        else if ( remain == 0){
            result.add(new ArrayList<>(tempList));
        }
        else {
            for ( int i = start ; i < nums.size(); i++){
                tempList.add(nums.get(i));
                backtrack(result, tempList, nums, remain-nums.get(i), i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
