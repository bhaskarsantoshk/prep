package amazon.trees;

public class SymmetricBinaryTree {
    public int isSymmetric(TreeNode A) {
        if ( A == null ) return 1;
        return isSymmetric(A.left, A.right) ? 1: 0;
    }

    private boolean isSymmetric(TreeNode s, TreeNode t) {
        if ( s == null || t == null ){
            return s == null && t == null;
        }
        return s.val == t.val && isSymmetric(s.left, t.right) && isSymmetric(s.right, t.left);
    }
}
