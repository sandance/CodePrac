import java.util.List;

import apple.laf.JRSUIUtils.Tree;

class Solution {

    public List<String> binaryPaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();

        if(root == null) {
            return paths;
        }
        dfs(root, paths, "");
        return paths;
    }


    private void dfs(TreeNode root, List<String> paths, String path ) {
        if(root.left == null && root.right == null) {
            paths.add(path);
            return;
        }

        path += root.val+"->";

        if(root.left != null) {
            dfs(root.left, paths, path);
        }

        if(root.right != null) {
            dfs(root.right, paths, path);
        }
    }
}