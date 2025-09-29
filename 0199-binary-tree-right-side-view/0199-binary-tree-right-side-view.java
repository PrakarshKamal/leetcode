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
    // Since Preorder is Root Left Right, we can do
    // reverse Preorder, which is Root Right Left
    // this will give the first node from right which is the ans
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, ans, 0);
        return ans;
    }

    // DFS O(n) time, O(h) space
    private void dfs(TreeNode root, List<Integer> ans, int level) {
        if (root == null) {
            return;
        }
        if (level == ans.size()) {
            ans.add(root.val);
        }
        dfs(root.right, ans, level + 1);
        dfs(root.left, ans, level + 1);
    }
}