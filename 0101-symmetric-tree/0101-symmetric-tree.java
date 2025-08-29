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
    // Recursive approach O(n) time, O(n) space
    // public boolean isSymmetric(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }
    //     return isSameTree(root.left, root.right);
    // }

    // private boolean isSameTree(TreeNode p, TreeNode q) {
    //     // Both are mirrors, return true
    //     if (p == null && q == null) {
    //         return true;
    //     }
    //     // Mismatch structure/values, not symmetric
    //     if (p == null || q == null || p.val != q.val) {
    //         return false;
    //     }
    //     return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    // }

    // BFS O(n) time, O(n) space
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        
        q1.offer(root.left);
        q2.offer(root.right);

        while (q1.size() > 0 && q2.size() > 0) {
            TreeNode leftTree = q1.poll();
            TreeNode rightTree = q2.poll();

            // Both are mirrors, skip and continue
            if (leftTree == null && rightTree == null) {
                continue;
            }
            // Mismatch structure, not symmetric
            if (leftTree == null || rightTree == null) {
                return false;
            }
            // Mismatch values, not symmetric
            if (leftTree.val != rightTree.val) {
                return false;
            }

            // Enqueue in mirror order
            q1.offer(leftTree.left);
            q1.offer(leftTree.right);

            q2.offer(rightTree.right);
            q2.offer(rightTree.left);
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}