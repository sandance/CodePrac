
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}


class Solution {
    public static TreeNode  LCA_Binary_Search_Tree(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        if(node== null)
            return null;

        if(node.val > p.val && node.val < q.val)
            return node;
        else if ( node.val > p.val && node.val > q.val) {
            return LCA_Binary_Tree(node.left, p, q);
        } else if (node.val < p.val && node.val < q.val) {
            return LCA_Binary_Tree(node.right, p, q);
        }
        
        return root;
       
    }
}


class Solution {
    public static TreeNode LCA_Binary_Tree(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;

        if (node == null)
            return null;

        if (root == p || root == q)
            return root;
        
        TreeNode left = LCA_Binary_Tree(root.left, p, q);
        TreeNode right = LCA_Binary_Tree(root.right, p, q);

        if (left != null && right != null)
            return root;
        else if (left )
    }
}