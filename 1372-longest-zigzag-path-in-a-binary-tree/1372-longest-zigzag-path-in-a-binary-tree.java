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
 // DFS O(n) time, O(n) space
class Solution {
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return ans;
    }
    public void dfs(TreeNode root, boolean isDirLeft, int length) {
        if (root == null) return;

        ans = Math.max(ans, length);

        if (isDirLeft) {
            dfs(root.left, false, length+1);
            dfs(root.right, true, 1);
        }
        else {
            dfs(root.right, true, length+1);
            dfs(root.left, false, 1);
        }
    }
}