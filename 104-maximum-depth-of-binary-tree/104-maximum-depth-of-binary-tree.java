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
// // DFS recursion
// class Solution {
//     public int maxDepth(TreeNode root) {
        
//         if (root == null) {
//             return 0;
//         }
//         else {
//             int l = maxDepth(root.left);
//             int r = maxDepth(root.right);
//             return Math.max(l, r) + 1;
//         }
//     }
// }

// BFS
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        int level = 1;
        int maxD = 0;
        
        q.add(root);
        
        while (!q.isEmpty()) {
            
            int s = q.size();
            
            for (int i = 0; i < s; i++) {
                
                TreeNode curr = q.remove();
                
                if (curr.left == null && curr.right == null) {
                    maxD = Math.max(maxD, level);
                }
                
                if (curr.left != null) {
                    q.add(curr.left);
                }
                
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            
            level++;
        }
        
        return maxD;
    }
}