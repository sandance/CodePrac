import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class SumOfPathNumbers {

    public static int find_sum_pathRecursive(TreeNode curNode, int curSum) {
        if (curNode == null) {
            return 0;
        }

        curSum = curSum * 10 + curNode.val;

        if (curNode.left == null && curNode.right == null) {
            return curSum;
        } 
       
        return find_sum_pathRecursive(curNode.left, curSum) + find_sum_pathRecursive(curNode.right, curSum);

    }

    public static int findSumOfPathNumbers(TreeNode root) {
        // TODO: Write your code here
       
        return find_sum_pathRecursive(root, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
