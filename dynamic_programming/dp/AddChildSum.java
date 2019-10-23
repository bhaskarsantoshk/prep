package dynamic_programming.dp;

import amazon.trees.TreeNode;

public class AddChildSum {
    public void addChildSum ( TreeNode root ){
        if ( root == null ){
            return;
        }
        addChildSum(root.left);
        addChildSum(root.right);
        root.val = (root.left!= null ? root.left.val : 0) + (root.right != null ? root.right.val : 0);
    }
}
