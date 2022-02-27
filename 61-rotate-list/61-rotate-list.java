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
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null) {
            return head;
        }
        
        int n = 1;
        ListNode tail = head;
        
        while (tail.next != null) {
            n++;
            tail = tail.next;
        }
        
        tail.next = head;
        
        k = k % n;
        k = n - k;
        
        for (int i = k; i > 0; i--) {
            tail = tail.next;
        }
        
        ListNode newHead = tail.next;
        tail.next = null;
        
        return newHead;
    }
}