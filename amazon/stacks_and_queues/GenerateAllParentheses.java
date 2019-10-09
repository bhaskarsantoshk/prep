package amazon.stacks_and_queues;

import java.util.Stack;

public class GenerateAllParentheses {
    public int isValid(String A) {
        Stack<Character> stack = new Stack<>();
        for ( int i=0; i< A.length(); i++){
            char c = A.charAt(i);
            if ( c == '(' || c== '{' || c == '['){
                stack.push(c);
            }
            else{
                if ( stack.isEmpty() ){
                    return 0;
                }
                char open = stack.pop();
                if ( (c == ')' && open=='(' ) || (c == ']' && open=='[' ) || (c == '}' && open=='{' )){
                    continue;
                }
                else{
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 1: 0;
    }
}
