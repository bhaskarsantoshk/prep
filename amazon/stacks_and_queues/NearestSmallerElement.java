package amazon.stacks_and_queues;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> result  = new ArrayList<>();
        if ( A == null || A.size() == 0) return result;
        for ( int i=0; i<A.size(); i++){
            while ( !stack.isEmpty() && stack.peek() >= A.get(i)){
                stack.pop();
            }
            if ( stack.isEmpty()){
                result.add(-1);
            }
            else{
                result.add(stack.peek());
            }
            stack.push(A.get(i));
        }
        return result;
    }
}
