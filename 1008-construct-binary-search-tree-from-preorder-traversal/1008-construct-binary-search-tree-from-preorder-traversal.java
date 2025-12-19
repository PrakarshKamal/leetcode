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

// O(n^2) time, O(n) space
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(0, preorder.length-1, preorder);
    }

    public TreeNode helper(int start, int end, int[] preorder) {
        if (start > end) return null; // base case

        // root at first elem
        int val = preorder[start];
        TreeNode root = new TreeNode(val);

        int idx = start;
        for (idx = start; idx <= end; idx++) {
            if (preorder[idx] > preorder[start]) {
                break;
            }
        }
        root.left = helper(start+1, idx-1, preorder);
        root.right = helper(idx, end, preorder);
        return root;
    }
}