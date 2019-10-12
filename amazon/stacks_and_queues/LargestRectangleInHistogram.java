package amazon.stacks_and_queues;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(ArrayList<Integer> A) {
        if ( A == null || A.size() == 0 ){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for ( int i=0; i<A.size(); i++){
            int currentHeight  = A.get(i);
            while ( stack.peek()!= -1 && currentHeight <= A.get(stack.peek())){
                int height = A.get(stack.pop());
                int width = i-stack.peek()-1;
                maxArea = Math.max ( maxArea, height * width);
            }
            stack.push(i);
        }
        while ( stack.peek() != -1){
            int height = A.get(stack.pop());
            int width= A.size()- stack.peek()-1;
            maxArea = Math.max ( maxArea, height * width);
        }
        return maxArea;
    }
}
