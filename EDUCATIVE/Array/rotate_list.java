/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        

        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        int i;


        for(i=0; fast != null; i++) {
            fast = fast.next;

        }

        for(j=i - n % i; j > 0 ; j--) {
            slow = slow. next;
        }

        fast.next = slow.next;
        slow.next = dummy;
        fast.next = null;

        return dummy.next;
    }
}