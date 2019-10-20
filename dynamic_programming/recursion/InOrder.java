package dynamic_programming.recursion;

import amazon.trees.TreeNode;

public class InOrder {
    public void inorder(TreeNode root){
        if ( root == null ) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
}
