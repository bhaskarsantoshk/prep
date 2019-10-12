package leetcode;

import java.util.Stack;

public class P84LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        if ( heights == null || heights.length == 0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for  ( int i=0; i<heights.length; i++){
            int currentHeight = heights[i];
            while ( stack.peek() != -1 && currentHeight <= heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = i-stack.peek()-1;
                maxArea = Math.max( maxArea, height*width);
            }
            stack.push(i);
        }
        while ( stack.peek() != -1){
            int height = heights[stack.pop()];
            int width = heights.length-stack.peek()-1;
            maxArea = Math.max( maxArea, height*width);
        }
        return maxArea;
    }
}
