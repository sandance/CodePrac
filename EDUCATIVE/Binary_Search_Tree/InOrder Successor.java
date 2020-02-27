

class Solution {
    public static TreeNode inOrderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)
            return null;

        TreeNode parent = null;
        TreeNode curr = root;

        while( curr != null && curr.val != p.val) {
            if(curr.val > p.val) {
                parent = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if( curr == null) {
            return null;

        }
        //case 2: no right node, display parent
        if( curr.right == null) {
            return parent;
        }

        curr = curr.right;
        // smallest element in the left subtree
        while(curr.left != null) {
            curr = curr.left;
        }
        
        return curr;
    }
}