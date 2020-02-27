import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class LevelOrderSuccessor {
  public static TreeNode findSuccessor(TreeNode root, int key) {
    // TODO: Write your code here
    Queue<TreeNode> queue = new LinkedList<>();
    
    if(root == null) {
        return root;
    }

    queue.offer(root);

    while(!queue.isEmpty()) {
        int levelSize = queue.size();
        
        

        for(int i=0; i < levelSize; i++) {
            
            TreeNode node = queue.remove();
          
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            if(node.val == key) {
              break;
            }
        }
    }
    
    return queue.peek();    
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
    if (result != null)
      System.out.println(result.val + " ");
    result = LevelOrderSuccessor.findSuccessor(root, 9);
    if (result != null)
      System.out.println(result.val + " ");
  }
}
