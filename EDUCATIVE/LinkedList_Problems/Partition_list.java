
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if( head == null || head.next ==  null)
            return head;

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        ListNode current1 = dummy1;
        ListNode current2 = dummy2;

        while(head != null) {
            if (head.val < x) {
                current1.next = head;
                current1 = head;

            } else {
                current2.next = head;
                current2 = head;
            }
            head = head.next;
        }

        current1.next = dummy2.next;
        current2.next = null;


        return dummy1.next;   
    }
}