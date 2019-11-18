

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
};


class Solution {
    /*
    The successor of a node p is the node with the smallest key greater than p.val. You will have direct access to
    the node but not to the root of the tree. Each node will have a reference to its parent node. A node is defined as
    the following:
    */
    public static TreeNode inorder_successor(TreeNode x) {
        TreeNode result = null;

        // case 1: right child is not null
        // Go down and find the right successor

        TreeNode p = x.right;

        while(p != null) {
            result = p;
            p = p.left;
        }

        if(result != null) {
            return result;
        }

        // case 2: right child is null, traverse the tree all the way till the 
        // node become the left child of parent. 

        p = x;

        while( p != null) {
            if(p.parent != null && p.parent.left == p) {
                return p.parent;
            }
            p = p.parent;
        }
        
        return null;

        }
    
}