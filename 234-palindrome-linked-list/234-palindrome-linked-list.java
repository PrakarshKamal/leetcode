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
    public boolean isPalindrome(ListNode head) {
        
        if (head == null) {
            return true;
        }
        
        ListNode curr = head;
        ListNode tail = head;
        
        while (curr != null && curr.next != null) {
            tail = tail.next;
            curr = curr.next.next;
        }
        
        tail = reverseLL(tail);
        curr = head;
        
        // now we have 1 2 3 4 1 2 3 4
        // so we compare from curr = 1 and tail = 1
        while (tail != null) {
            if (curr.val != tail.val) {
                return false;
            }
            curr = curr.next;
            tail = tail.next;
        }
        return true;
    }
    
    // function to reverse LL
    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;  
        }
        return prev;
    }
}