
import java.io.*;

class Solution {
    double min = Integer.MAX_VALUE;
    int minValueNode = 0;

    public int closestValue(TreeNode root, int target) {
        closestValueRecursive(root, target);
        return minValueNode;
    }

    public void closestValueRecursive(TreeNode root, double target) {
        if(root == null) {
            return;
        }

        if(Math.abs(root.val - target) < min) {
            min = (root.val - target); 
            minValueNode = root.val;
            //return minValueNode;
        }

        if(target < root.val ) {
            closestValueRecursive(root.left, target);
        } else {
            closestValueRecursive(root.right, target);
        } 
    }
}





