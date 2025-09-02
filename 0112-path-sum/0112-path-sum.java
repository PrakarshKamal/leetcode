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
    // Recursive DFS O(n) time, O(n) space
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, 0, targetSum);
    }
 
    private boolean dfs(TreeNode root, int currSum, int targetSum) {
        if (root == null) {
            return false;
        }

        currSum += root.val;

        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                return true;
            }
        }

        boolean leftPath = dfs(root.left, currSum, targetSum);
        boolean rightPath = dfs(root.right, currSum, targetSum);

        if (leftPath || rightPath) {
            return true;
        }
        return false;
    }
}