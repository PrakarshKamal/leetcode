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
    public List<Integer> postorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        postOrder(root);
        return ans;
    }

    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        ans.add(root.val);
    }

    // Iterative O(n) time, O(n) space
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     ans = new ArrayList<>();
    //     Stack<TreeNode> stack = new Stack<>();

    //     stack.push(root);

    //     while (!stack.isEmpty() && root != null) {
    //         TreeNode curr = stack.pop();
    //         ans.addFirst(curr.val);
            
    //         if (curr.left != null) {
    //             stack.push(curr.left);
    //         }
    //         if (curr.right != null) {
    //             stack.push(curr.right);
    //         }
    //     }
    //     return ans;
    // }
}