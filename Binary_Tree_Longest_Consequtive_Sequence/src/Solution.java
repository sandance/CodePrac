import java.io.*;


public class Solution {

    public static void dfs(TreeNode node, int pathLen, int target, int res) {

        if(node == null)
            return;

        if (node.val == target) {
            ++pathLen;
        } else {
            pathLen = 1;
        }

        res = Math.max(res, pathLen);

        dfs(node.left, pathLen, node.val + 1, res);
        dfs(node.right, pathLen, node.val + 1, res);

    }

   public static int BT_LCS(TreeNode root) {
        int res=0;
        dfs(root, 0, 0, res);
        return res;
   }
}
