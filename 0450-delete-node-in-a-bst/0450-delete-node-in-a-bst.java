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
    // Recursive method, O(h) time, O(h) space, On average h = log n
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            else { 
                // we are removing root.val == key so we have to update BST
                // by taking minimum of right subtree and updating root.val to min.val
                TreeNode min = minValNode(root.right); // find min in right subtree
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
        }
        return root;
    }

    private TreeNode minValNode(TreeNode root) {
        if (root == null) {
            return root;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}