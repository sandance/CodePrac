class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) {
            return null;
        }

        TreeNode parent = null;
        TreeNode current = root;
        while( current != null && current.val != p.val ) {
            if ( current.val > p.val) {
                parent = current;
                current = current.left;
            } else {
                current = current.right;
            }

        }

        if( current == null) {
            return null;
        }

        if ( current.right == null) {
            return parent;
        }

        current = current.right;

        while(current.left != null) {
            current = current.left;
        }

        // 
        return current;


}