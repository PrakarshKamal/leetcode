/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        
        int lenOfA = getLength(headA);
        int lenOfB = getLength(headB);
        
        int diff = Math.abs(lenOfA - lenOfB);
        
        ListNode first, second;
        
        if (lenOfA > lenOfB) {
            first = headA;
            second = headB;
        }
        else {
            first = headB;
            second = headA;
        }
        
        while (diff > 0) {
            first = first.next;
            diff--;
        }
        
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first; // or second
    }
    
    private int getLength(ListNode head) {
        
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}