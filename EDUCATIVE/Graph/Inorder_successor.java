

class Solution {

    List<TreeNode
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // one way to do it do inorder and then return  the next element from the list
        if(root == null) {
            return null;
        }

       TreeNode parent = null;
       TreeNode current = root;
        // find the node first
       while(current != null && current.val != p.val) {
           if(current.val > p.val) {
               parent = current;
               current = current.left;

           } else {
               current = current.right;
           }
       }

       // no node left to search, not found
       if (current == null) {
           return null;
       }

       // check if the node has right subtree
       if (current.right == null) {
           return parent;
       }

       // if the node has right subtree, find the left most node of the right subtree
       if(current.right != null) {
           current = current.right;
           while(current.left != null) {
               //parent = current;
               current = current.left;
           }
       }

       return current;
        
    }
}