package amazon.trees;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagLevelOrderTraversalBT {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<TreeNode> currentList = new Stack<>();
        Stack<TreeNode> nextList = new Stack<>();
        currentList.add(A);
        int index = 0;
        result.add(new ArrayList<>());
        boolean leftToRight = true;
        while ( !currentList.isEmpty() ){
            TreeNode popped = currentList.pop();
            result.get(index).add(popped.val);
            if ( leftToRight ){
                if ( popped.left != null ){
                    nextList.push(popped.left);
                }
                if ( popped.right != null ){
                    nextList.push(popped.right);
                }
            }
            else{
                if ( popped.right != null ){
                    nextList.push(popped.right);
                }
                if ( popped.left != null ){
                    nextList.push(popped.left);
                }
            }
            if ( currentList.isEmpty() ){
                Stack<TreeNode> temp = currentList;
                currentList = nextList;
                nextList = temp;
                leftToRight = !leftToRight;
                result.add(new ArrayList<>());
                index++;
            }
        }
        return result;
    }
}
