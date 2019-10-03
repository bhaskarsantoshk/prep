package amazon.trees;

public class PopulateNextRightPointersTree {
    public void connect(TreeLinkNode root) {
        if ( root == null ) return;
        TreeLinkNode start = root;
        while ( start != null ){
            TreeLinkNode cur = start;
            while ( cur != null ){
                if ( cur.left!= null ){
                    cur.left.next = cur.right;
                }
                if ( cur.right != null && cur.right.next!= null ){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
    }
}
