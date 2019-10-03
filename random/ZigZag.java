package random;

import java.util.Stack;

public class ZigZag {


    /*

     1
   2  3
  4 5   6

next : , cur: 6 5 4

  1  3  2 4 5 6

     */
    private void zigzagLevelOrderTraversal(TreeNode root){
        if ( root == null ) return;
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        current.push(root);
        boolean leftToRight = true;
        while ( !current.isEmpty() ){
            TreeNode popped = current.pop();
            System.out.print(popped.val+" ");
            if ( leftToRight ){
                if ( popped.left != null ){
                    next.push(popped.left);
                }
                if ( popped.right != null ){
                    next.push(popped.right);
                }
            }
            else if (!leftToRight){
                if ( popped.right != null ){
                    next.push(popped.right);
                }
                if ( popped.left != null ){
                    next.push(popped.left);
                }
            }
            if ( current.isEmpty()){
               leftToRight = !leftToRight;
               Stack<TreeNode> temp = current;
               current = next;
               next = null;
               System.out.println();
            }
        }

    }


    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            left = null;
            right = null;
            val = val;
        }
    }
}
