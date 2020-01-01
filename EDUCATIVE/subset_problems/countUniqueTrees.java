import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class CountUniqueTrees {

    public int countTrees(int n) {
        // TODO: Write your code here
        if (n <= 1) {
            return 1;
        }

        int count = 0;
        for(int i=1; i <= n; i++) {
            int countOfLeftSubTree = countTrees(i-1);
            int countOfRightSubTree = countTrees(n-i);

            count += (countOfLeftSubTree * countOfRightSubTree);
        }
        return count;
    }

    public static void main(String[] args) {
        CountUniqueTrees ct = new CountUniqueTrees();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count);
    }
}
