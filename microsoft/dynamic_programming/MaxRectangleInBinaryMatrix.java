package microsoft.dynamic_programming;

import java.util.ArrayList;
import java.util.Stack;

public class MaxRectangleInBinaryMatrix {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int[][] a = new int[A.size()][A.get(0).size()];
        for ( int i=0; i< A.size(); i++){
            for ( int j=0; j<A.get(0).size(); j++){
                if ( i == 0 ){
                    a[i][j] = (A.get(i).get(j) == 0) ? 0: 1;
                }
                else{
                    a[i][j] = (A.get(i).get(j) == 0) ? 0: a[i-1][j]+1;
                }
            }
        }
        int res = 0;
        for ( int i=0; i< a.length; i++){
            int area = maxAreaOfHistogram(a[i]);
            res = Math.max ( res, area);
        }
        return res;
    }

    private int maxAreaOfHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for ( int i=0; i<=heights.length; i++){
            int h = ( i == heights.length) ? 0: heights[i];
            if ( stack.isEmpty() || h>= heights[stack.peek()]){
                stack.push(i);
            }
            else{
                int top = stack.pop();
                int area = heights[top] * ( stack.isEmpty() ? i: i-stack.peek()-1);
                i--;
                maxArea = Math.max ( area, maxArea);
            }
        }
        return maxArea;
    }
}
