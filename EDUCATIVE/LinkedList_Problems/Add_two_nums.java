/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

Class Solution {
  public static ListNode add_numbers (ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null)
      return ListNode(0);

      int carry = 0;
      ListNode curr = null;
      ListNode head = null;

      //List<ListNode> result = new ArrayList<ListNode>();

      while( l1!= null || l2!= null) {
        int sum = carry;
        if ( l1 != null) {
          sum += l1.val;
          l1 = l1.next;
        }

        if (l2 != null) {
          sum += l2.val;
          l2 = l2.next;
        }

        ListNode newNode = new ListNode(sum % 10);

        if ( curr == null){
          curr = newNode;
          head = newNode
        } else {
          curr.next = newNode;
          curr = curr.next;
        }

        carry = sum / 10;
      }// end of List

      if (carry == 1) {
        //no more node add as a separate newNode
        curr.next = ListNode(1);
      }

      // handle empty list secnario
      return head != null ? head : new ListNode(0);
  }
}
