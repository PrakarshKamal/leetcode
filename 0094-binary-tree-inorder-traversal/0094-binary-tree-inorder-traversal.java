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

    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }

    // Iterative O(n) time, O(n) space
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     ans = new ArrayList<>();
    //     Stack<TreeNode> stack = new Stack<>();

    //     while (root != null || !stack.isEmpty()) {
    //         while (root != null) {
    //             stack.push(root);
    //             root = root.left;
    //         }
    //         root = stack.pop();
    //         ans.add(root.val);
    //         root = root.right;
    //     }
    //     return ans;
    // }
}