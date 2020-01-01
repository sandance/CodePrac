import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.*;

/*Example: Given binary tree
    1
    / \
    2 3
   / \
   4 5
Returns [4, 5, 3], [2], [1].*/




class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        this.val = x;
    }
};

/*
 *
 * The key to solve this problem is converting the problem to be finding the
 * index of the element in the result list. Then this is a typical DFS problem
 * on trees.
 */

class Solution {

    private static int helper(List<List<Integer>> result, TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = helper(result, root.left);
        int right = helper(result, root.right);

        int currentOrder = Math.max(left, right) + 1;

        // First time the code is reached here when currentOrder == 0

        if (result.size() <= currentOrder) {
            result.add(new ArrayList<Integer>());
        }

        result.get(currentOrder).add(root.val);

        return currentOrder;
    }

    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        helper(result, root);
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);

        List<List<Integer>> result = findLeaves(root);

        for(List<Integer> arr : result) {
            System.out.println(arr);
        }

    }
}