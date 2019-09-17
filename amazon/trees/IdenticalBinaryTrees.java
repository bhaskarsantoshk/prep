package amazon.trees;

public class IdenticalBinaryTrees {
    public int isSameTree(TreeNode A, TreeNode B) {
        return isSame(A,B) == true ? 1: 0;
    }

    private boolean isSame(TreeNode A, TreeNode B) {
        if ( A == null || B == null ){
            return (A == null && B == null) ;
        }
        return (A.val == B.val && isSame(A.left, B.left) && isSame(A.right, B.right)) ;
    }
}
