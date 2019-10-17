package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int[] candidates, int remain, int start) {
        if ( remain < 0 ){
            return;
        }
        else if ( remain == 0){
            result.add ( new ArrayList<>(tempList));
        }
        else{
            for ( int i= start ; i < candidates.length; i++){
                if(i > start && candidates[i] == candidates[i-1]) continue;
                tempList.add(candidates[i]);
                backtrack(result, tempList, candidates, remain-candidates[i], i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
