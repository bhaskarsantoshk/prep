package amazon.twopointers;

import java.util.ArrayList;

public class ContainerWithMostWater {
    public int maxArea(ArrayList<Integer> A) {
        int len = A.size()-1;
        int left = 0;
        int right = len;
        int maxArea = 0;
        while ( left < right){
            maxArea = Math.max ( maxArea, Math.min(A.get(left), A.get(right)) * (right-left));
            if ( A.get(left) > A.get(right)){
                right--;
            }
            else{
                left++;
            }
        }
        return maxArea;
    }
}
