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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode ans = root;
        if (ans == null) {
            return ans;
        }
        if (val > root.val) {
            ans = searchBST(root.right, val);
        }
        else if (val < root.val) {
            ans = searchBST(root.left, val);
        }
        return ans;
    }
}