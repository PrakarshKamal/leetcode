/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode fast = dummy;
        
        int i = 1;
        while (i <= n+1) {
            fast = fast.next;
            i++;
        }
        
        ListNode slow = dummy;
        
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // delete operation
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}