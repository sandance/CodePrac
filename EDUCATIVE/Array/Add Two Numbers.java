/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode curr = null;
        ListNode head = null;

        int sum =0, carry = 0;

        ListNode result = null;

        while(l1 != null || l2 != null) {
             sum = carry;

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode newNode = new ListNode(sum % 10); // most significant bit

            if (curr == null) {
                curr = newNode;
                head = newNode;
            } else {
                curr.next = newNode;
                curr = curr.next;

            }

            carry = sum / 10;

            
        } // end of sum

        // if the carray occurs after the last element

        if (carry == 1) {
            curr.next = new ListNode(1);
        }

        return head != null ? head : new ListNode(0);

    }
}