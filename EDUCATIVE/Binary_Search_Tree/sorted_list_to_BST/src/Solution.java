/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        TreeNode root = createBST(head, null);
        return root;

    }

    private static TreeNode createBST(ListNode head, ListNode tail) {

        while( head != tail) {
            //find mid node
            ListNode fast = head;
            ListNode slow = head;

            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            // found middle as slow
            TreeNode node = new TreeNode(slow.val);
            node.left = createBST(head, slow);
            node.right = createBST(slow.next, tail)
        }

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

        System.out.println("Search Index: " +  createBST(nums, target));



    }
}
