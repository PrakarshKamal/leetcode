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

// Using List to store inorder and checking i and i-1 val
class Solution {
    List<Integer> bst = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for (int i = 1; i < bst.size(); i++) {
            if (bst.get(i) <= bst.get(i-1)) {
                return false;
            }
        }
        return true;
    }
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        bst.add(root.val);
        inorder(root.right);
    }
}