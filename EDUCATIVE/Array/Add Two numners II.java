import java.util.ArrayList;
import java.util.HashSet;

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
       Stack<TreeNode> set1 = new ArrayList<>();
       Stack<TreeNode> set2 = new ArrayList<>();
       int sum = 0;
       int carry = 0;

       ListNode result = null;
       ListNode head = null;

       while(l1 != null) {
           set1.add(l1);
           l1 = l1.next;
       }

       while(l2 != null) {
        set1.add(l2);
        l2 = l2.next;
       }

       while(!set1.empty() || !set2.empty()) {
            sum = carry;
            if(!set1.empty()) {
                ListNode curr1 = set1.pop();
                sum += curr1.val;

            }

            if (!set2.empty()){
                ListNode curr2 = set2.pop();
                sum += curr2.val;
            }

            ListNode newNode = new ListNode(sum % 10);

            if(result == null) {
                head = newNode;
                result = newNode;
            } else {
                result.next = newNode;
                result = result.next;
            }

            carry = sum / 10;
            

       }

       if(carry == 1) {
           result.next = new ListNode(1);
       }


       return result != null ? head : new ListNode(0);
       
    }
}