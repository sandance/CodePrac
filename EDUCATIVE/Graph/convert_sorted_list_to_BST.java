/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class ListNode {
    int val;
    ListNode next;
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}


class Solution {

    public static int getLength(ListNode head) {
        int len = 0;
        ListNode currentNode = head;

        while(currentNode != null) {
            len++;
            currentNode = currentNode.next;
        }
        
        return len;
    }

    public TreeNode sortedListToBST(int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBST(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }

    public static ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        
        if (head == null) {
            return null;
        }
        
        current = head;

        int len = getLength(head);
        return sortedListToBST(0, len -1);   
    }
}