import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class FindAllTreePaths {

    public static void findPathsRecursive(TreeNode node, int sum, List<Integer> curPath, List<List<Integer>> allPaths) {

        if(node == null) {
            return;
        }

        curPath.add(node.val);

        if(node.val == sum && node.left == null && node.right == null) {
            allPaths.add(new ArrayList<>(curPath));          
        } else {
            findPathsRecursive(node.left, sum - node.val, curPath, allPaths);
            findPathsRecursive(node.right, sum - node.val, curPath, allPaths);
        }

        // remove the current node from the node to backtrack
        // we need to remove the current node while we are going up the recursion call stack
        curPath.remove(curPath.size() -1);
    }

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        // TODO: Write your code here

        findPathsRecursive(root, sum, currentPath, allPaths);
        return allPaths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
