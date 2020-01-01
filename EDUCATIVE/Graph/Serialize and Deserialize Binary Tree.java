import java.util.*;


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * You may serialize the following tree:
 * 
 * 1 
 * / \ 
 * 2 3 
 *    / \ 
 *    4 5
 * 
 * as "[1,2,3,null,null,4,5]"
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode != null) {
                sb.append(String.valueOf(currentNode.val));
                if(currentNode.left != null)
                    queue.add(currentNode.left);
                
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            } else {
                sb.append("#,");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }

        String [] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int i =1;

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if(currentNode ==  null) {
                continue;
            }
            if(!arr[i].equals("#")) {
                currentNode.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(currentNode.left());

            } else {
                currentNode.left = null;
                queue.offer(null);
            }


            i++;

            if (!arr[i].equals("#")) {
                currentNode.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(currentNode.right());

            } else {
                currentNode.right = null;
                queue.offer(null);
            }

            i++;
        }

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));