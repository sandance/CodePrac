
class Solution {

    public static boolean isPalindrome(ListNode head) {
        if ( head == null || head.next == null) {
            return true;
        }

        /* Floyd menthod to find the mid element */
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = reverseList(slow.next);

        // compare first and second half

        slow = slow.next;
        while(slow != null) {
            if ( head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }

        return true;
    }
 
    public static ListNode  reverseList(ListNode head) {
        //ListNode current = head;
        ListNode pre = null;
        ListNode next = null;


        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}