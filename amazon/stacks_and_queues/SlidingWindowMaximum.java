package amazon.stacks_and_queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        if ( A == null || A.size() == 0 || B <= 0){
            return result;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for ( int i=0;i < A.size(); i++){
            while ( !dq.isEmpty() && dq.peek() < i-B+1){
                dq.poll();
            }
            while ( !dq.isEmpty() && A.get(dq.peekLast()) < A.get(i)){
                dq.poll();
            }
            dq.offer(i);
            if ( i >= B-1){
                result.add(dq.peek());
            }
        }
        return result;
    }
}
