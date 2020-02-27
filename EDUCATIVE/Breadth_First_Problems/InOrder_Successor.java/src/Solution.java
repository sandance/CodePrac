import java.io.*;


public class Solution {

    public static TreeNode inorder_successor(TreeNode root, TreeNode p) {

        if (root == null)
            return null;

        TreeNode parent = null;
        TreeNode current = root;

        while(current !=null && current.val != p.val) {
            if(current.val > p.val) {
                parent = current;
                current = current.left;
            } else {
                current = current.right;
            }

            if(current == null]
                return  null;

            if(current.right == null)
                return parent;

            current = current.right;

            while(current.left != null) {
                current = current.left;
            }

            return current;

        }
    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner();

        System.out.println("Enter number of elements in Arrays");
        int n = sc.nextInt();
        int [] nums = new int[n];

        for (int i=0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter the target element");
        int target = sc.nextInt();

        System.out.println("Search Index: " +  inorder_successor());



    }
}
