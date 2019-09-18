package amazon.trees;

public class MinDepthofBinaryTree {
    public int minDepth(TreeNode A) {
        if ( A == null ) return 0;
        int left = minDepth(A.left) ;
        int right = minDepth(A.right);
        return left == 0 || right == 0 ? left+right+1 : Math.min(left, right)+1;
    }
}
