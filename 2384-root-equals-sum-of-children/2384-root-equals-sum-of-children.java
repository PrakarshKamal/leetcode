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
    // O(1) time, O(1) space
    public boolean checkTree(TreeNode root) {
        if (root == null) return false;
        int sum = root.val;
        if ((root.left.val + root.right.val) == sum) {
            return true;
        }
        return false;
    }
}