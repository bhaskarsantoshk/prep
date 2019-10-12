package amazon.stacks_and_queues;

import java.util.Stack;

public class RedundantBraces {
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for ( char c: A.toCharArray()){
           if ( c == '(' || c == '+' || c == '-' || c == '*' || c == '/'){
               stack.push(c);
           }
           else if ( c == ')'){
               if ( stack.peek() == '('){
                   return 1;
               }
               else{
                   while ( !stack.isEmpty() && stack.peek() != '('){
                       stack.pop();
                   }
                   stack.pop();
               }
           }
        }
        return 0;
    }
}
