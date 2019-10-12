package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if ( nums == null || nums.length == 0 || k<=0){
            return new int[0];
        }
        int result [] = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int ri =0;
        for ( int i=0; i<nums.length; i++){
            while ( !dq.isEmpty() && dq.peek() < i-k+1){
                dq.poll(); // pollFirst
            }
            while ( !dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offer(i);

            if ( i >= k-1){
                result[ri++] = nums[dq.peek()];
            }
        }
        return result;
    }
}
