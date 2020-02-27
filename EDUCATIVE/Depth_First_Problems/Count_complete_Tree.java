

public int countNodes(TreeNode root)
{
    if(root == null)
        return 0;

    return 1 + countNodes(root.left) + countNodes(root.right);
}


public int countNodes(TreeNode root) {
    if(root == null)
        return 0;

    int left = getLeftHeight(root) + 1;
    int right = getRightHeight(root) + 1;

    if(left == right)
        return 
}
public int getHeight(TreeNode root) {

    int height = 0;

    while(node.right != null)
}