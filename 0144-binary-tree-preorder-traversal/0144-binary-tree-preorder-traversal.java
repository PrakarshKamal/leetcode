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
    // Recursive O(n) time, O(n) space
    List<Integer> ans;
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     ans = new ArrayList<>();
    //     preorder(root);
    //     return ans;
    // }

    // private void preorder(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     ans.add(root.val);
    //     preorder(root.left);
    //     preorder(root.right);
    // }

     public List<Integer> preorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                ans.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return ans;
     }
}