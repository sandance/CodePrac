/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
       if(head == null) {
           return null;
       }
        
       ListNode start = new ListNode(0);
       start.next = head;

       ListNode slow = start;
       ListNode fast = start;

       //first point start at N+1 position
       for(int i=0; i < n + 1 && fast != null; i++) {
           fast = fast.next;
       }
       // slow pointer reaches lengreturn headth-Nth 
       while(fast != null) {
           slow = slow.next;
           fast = fast.next;
       }

       slow.next = slow.next.next;

       

       return start.next;
    }
}