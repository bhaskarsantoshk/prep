package amazon.dynamic_programming;

import amazon.trees.TreeNode;

public class MaxSumPathInBinaryTree {
    int max;
    public int maxPathSum(TreeNode A) {
        max = Integer.MIN_VALUE;
        maxPath(A);
        return max;
    }

    private int maxPath(TreeNode root) {
        if ( root == null ) return 0;
        int left = Math.max ( 0, maxPath(root.left));
        int right = Math.max ( 0, maxPath(root.right));
        max = Math.max ( max, left+right+ root.val);
        return Math.max( left, right) + root.val;
    }
}
