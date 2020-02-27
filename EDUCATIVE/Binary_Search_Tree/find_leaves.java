

private int helper ( List<List<Integer>> list, TreeNode root) {

    if(root == null)
        return -1;

    int left = helper(list, root.left);
    int right = helper(list, root.right );
    int curr = Math.max(left, right ) + 1
    
}