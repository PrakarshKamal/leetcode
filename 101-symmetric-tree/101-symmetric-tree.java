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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; 
        }
        else {
            return check(root.left, root.right);
        }
    }
    
    private boolean check(TreeNode leftSubTree, TreeNode rightSubTree) {
         if (leftSubTree == null && rightSubTree == null) {
             return true;
         }
        
        else if (leftSubTree == null || rightSubTree == null || leftSubTree.val != rightSubTree.val) {
            return false;
        }
        
        else {
            return check(leftSubTree.left, rightSubTree.right) && check(leftSubTree.right, rightSubTree.left);
        }
    }
}