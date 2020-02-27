import java.util.ArrayList;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}





class Solution {

    public static void dfs(TreeNode node, ArrayList<TreeNode> tree, ArrayList<ArrayList<TreeNode>> all) {
        //tree.add(node);

        if (node.left == null && node.right == null) {
            all.add(new ArrayList<TreeNode> (tree));
            
        }

        if (node.left != null) {
            tree.add(node.left);
            dfs(node.left, tree, all);
            tree.remove(tree.size() - 1);
        }

        if (node.right != null) {
            tree.add(node.right);
            dfs(node.right, tree, all);
            tree.remove(tree.size() -1);
        }
    }

    public int sumNumbers(TreeNode root) {
        int result = 0;

        if (root == null) return result;
        ArrayList<ArrayList<TreeNode>> all = new ArrayList<>();
        ArrayList<TreeNode> tree = new ArrayList<TreeNode>();
        tree.add(root);

        dfs(root, tree, all);
        
        for(ArrayList<TreeNode> a : all) {
            StringBuilder sb = new StringBuilder();
            for(TreeNode n : a) {
                sb.append(String.valueOf(n.val));
            }
            int currentValue = Integer.valueOf(sb.toString());
            result = result + currentValue;
        }
        return result;
    }
}


public int sumNumbers(TreeNode root) {
    if (root == null)
        return 0;

    return dfs(root, 0, 0);

}

public int dfs (TreeNode node, int num, int sum) {
    if(node == null)
        return sum;
    
    num = num * 10 + node.val;

    if (node.left == null && node.right == null) {
        sum += num;
        return sum;
    }

    sum += dfs (node.left, num , sum) + dfs(node.right , num, sum);
    return sumn

}
