import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class TreeBoundary {
    public static List<TreeNode> findBoundary(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        // TODO: Write your code here
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return result;
        }

        queue.offer(root);
        //TreeNode previousNode = null;
        

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            for(int i=0; i < levelSize; i++) {
                
                TreeNode curTreeNode = queue.remove();
                if(i == levelSize -1 && i == 0) {
                    result.add(curTreeNode);
                } else if ( i == levelSize -1 && )
                
                if(curTreeNode.left != null) {
                    queue.add(curTreeNode.left);
                }

                if(curTreeNode.right != null) {
                    queue.add(curTreeNode.right);
                }

                
            }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(15);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        List<TreeNode> result = TreeBoundary.findBoundary(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}
