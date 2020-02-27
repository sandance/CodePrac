import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int x) {
        val = x;
        left = right = next = null;
    }
};

class ConnectAllSiblings {
    public static void connect(TreeNode root) {
        // TODO: Write your code here

        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return;
        }

        queue.offer(root);
        TreeNode previousNode = null;
        

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

           

            for(int i=0; i < levelSize; i++) {
                
                TreeNode curTreeNode = queue.remove();
                if(i == levelSize -1) {

                }
                
                previousNode = curTreeNode;
                

                if(curTreeNode.left != null) {
                    queue.add(curTreeNode.left);
                }

                if(curTreeNode.right != null) {
                    queue.add(curTreeNode.right);
                }

                
            }






        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNode current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}