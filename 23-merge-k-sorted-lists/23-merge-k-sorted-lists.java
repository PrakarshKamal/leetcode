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
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode dummyHead = new ListNode();
        
        ListNode tail = dummyHead;
        
        while(true) {
            
            // get min node
            ListNode min = null;
            int index = -1;
            
            for(int i = 0; i < lists.length; i++) {               
                ListNode node = lists[i];
                
                if (node != null) {
                    if (min == null || node.val < min.val) {
                        index = i;
                        min = node;
                    }
                }
            }
            
            if (min == null) {
                break;
            }
            
            tail.next = min;
            tail = tail.next;
            lists[index] = lists[index].next;
        }
        
        return dummyHead.next;
    }
}