/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                break;
            }
        }
        
        // no cycle
        if (fast == null || fast.next == null) {
            return null;
        }
        
        // cycle exists
        ListNode x = head;
        ListNode y = slow; // or fast;
        
        while(x != y) {
            x = x.next;
            y = y.next;
        }
        
        return x;
    }
}