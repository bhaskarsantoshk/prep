package ctci.C8RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class PowerSet {
    ArrayList<ArrayList<Integer>> getSubSets( int[] nums ){
        ArrayList<ArrayList<Integer>> allSubSets = new ArrayList<>();
        backtrack( nums, allSubSets, new ArrayList<>(), 0);
        return allSubSets;
    }

    private void backtrack(int[] nums, ArrayList<ArrayList<Integer>> allSubSets, ArrayList<Integer> tempList, int index) {
        allSubSets.add(new ArrayList<>(tempList));
        for ( int i= index; i<nums.length; i++){
            tempList.add(nums[i]);
            backtrack(nums, allSubSets, tempList, index);
            tempList.remove(tempList.size()-1);
        }
    }
}
