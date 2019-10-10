package amazon.trees;

public class LeastCommonAncestor {
    public int lca(TreeNode A, int B, int C) {
        if(!doesExist(A, B) || !doesExist(A, C)) {
            return -1;
        }
        TreeNode lca=  leastCommonAncestor(A, B, C);
        return lca == null ? -1 : lca.val;
    }

    private boolean doesExist(TreeNode root, int num) {
        if (root == null) return false;
        if (root.val == num) return true;

        return doesExist(root.left, num) || doesExist(root.right, num);
    }

    private TreeNode leastCommonAncestor(TreeNode root, int a, int b) {
        if ( root == null){
            return root;
        }
        TreeNode left = leastCommonAncestor(root.left, a, b);
        TreeNode right = leastCommonAncestor(root.right, a, b);
        if ( root.val == a || root.val == b){
            return root;
        }
        if ( left != null && right != null ){
            return root;
        }
        return  left != null ? left: right;
    }
}
