class TreeNode {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};


// Given the node itself and find the inorder successor
class Solution {
    public static TreeNode inorderSuccessor(TreeNode x) {
        
        TreeNode result = null;

        // check if the is a right subtree
        TreeNode current = x.right;

        if(current != null) {
            result = current;
            current = current.left;
        }

        if(result != null) {
            return result;
        }

        // case 2: no right subtree, go up to parent and until the node if
        // left child, return parent

        while(current != null) {

            if(current.parent != null && current.parent.left == current) {
                return p.parent;
            }

            current = current.parent;


        }

        return null;

        
    }
}