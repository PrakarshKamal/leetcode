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
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );
        
        ListNode dummyHead = new ListNode();
        
        ListNode tail = dummyHead;
        
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        
        while(!pq.isEmpty()) {
            ListNode min = pq.remove(); // log k time
            if (min.next != null) {
                pq.add(min.next);
            }
            tail.next = min;
            tail = min;
        }
        return dummyHead.next;
    }
}