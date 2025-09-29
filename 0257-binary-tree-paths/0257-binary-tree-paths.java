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
    // DFS O(n) time, O(n) space
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        getPathDFS(root, ans, "");
        return ans;
    }

    private void getPathDFS(TreeNode root, List<String> ans, String s) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ans.add(s + root.val);
            return;
        }
        getPathDFS(root.left, ans, s + root.val + "->");
        getPathDFS(root.right, ans, s + root.val + "->");
    }
}