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
    public List<TreeNode> allPossibleFBT(int n) {
        return helper(n);
    }
    public List<TreeNode> helper(int n) {
        List<TreeNode> ans = new ArrayList<>();
        TreeNode root = new TreeNode(0);
        if (n <= 1) { // base case
            ans.add(root);
            return ans;
        }
        List<TreeNode> leftNodes;
        List<TreeNode> rightNodes;
        // left + right should equal n-1 nodes, 1 node for root
        for (int i = 1; i < n-1; i+=2) { // increment by 2 since it needs to be odd
            leftNodes = helper(i); 
            rightNodes = helper(n-1-i);

            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}