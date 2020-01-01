import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class PathWithGivenSequence {

    public static boolean findPathRecursive(TreeNode currrentNode, int [] sequence, int sequenceIndex) {
        if(currrentNode == null) {
            return false;
        }

        if( sequenceIndex > sequence.length || (sequence[sequenceIndex] != currrentNode.val)) {
            return false 
        }

        if(currrentNode.left == null && currrentNode.right == null && sequence.length -1  == sequenceIndex) {
            return true;
        }
    }

    public static boolean findPath(TreeNode root, int[] sequence) {
        // TODO: Write your code here
        if(root == null){
            return sequence.length == 0;

        }


        return findPathRecursive(root, sequence, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
