package amazon.stacks_and_queues;

import java.util.List;

public class RainWaterTrapped {
    public int trap(final List<Integer> A) {
        int leftMax=0, rightMax=0;
        int start =0, end = A.size()-1;
        int total_water =0;
        while ( start < end){
            leftMax = Math.max ( leftMax, A.get(start));
            rightMax = Math.max ( rightMax, A.get(end));
            if ( leftMax < rightMax){
                total_water+= leftMax - A.get(start++);
            }
            else{
                total_water+= rightMax- A.get(end--);
            }
        }
        return total_water;
    }
}
