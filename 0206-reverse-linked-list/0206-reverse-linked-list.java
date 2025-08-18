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
    public ListNode reverseList(ListNode head) {
        // Stack approach O(n) time, O(n) space
        // if (head == null || head.next == null) {
        //     return head;
        // }

        // Stack<ListNode> stack = new Stack<>();

        // ListNode curr = head;

        // while (curr != null) {
        //     stack.push(curr);
        //     curr = curr.next;
        // }

        // ListNode rev = stack.pop();
        // curr = rev;

        // while (!stack.isEmpty()) {
        //     curr.next = stack.pop();
        //     curr = curr.next;
        // }
        // curr.next = null;
        // return rev;


        // Iterative approach O(n) time, O(1) space
        // if (head == null || head.next == null) {
        //     return head;
        // }
        // ListNode prev = null;
        // ListNode curr = head;

        // while (curr != null) {
        //     ListNode temp = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = temp;
        // }
        // return prev;

        // Recursive approach O(n) time, O(1n space
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;

        if (head.next != null) {
            curr = reverseList(head.next);
            head.next.next = head;
        }
        head.next = null;
        return curr;
    }
}