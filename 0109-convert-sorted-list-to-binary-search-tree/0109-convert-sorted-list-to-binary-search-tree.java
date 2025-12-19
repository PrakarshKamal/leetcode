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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ListNode curr;

    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        curr = head;
        return helper(0, length-1);
    }
    public TreeNode helper(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start+end) / 2;
        TreeNode left = helper(start, mid-1);
        TreeNode root = new TreeNode(curr.val); // inorder step
        root.left = left;
        curr = curr.next;
        root.right = helper(mid+1, end);
        return root;
    }
}