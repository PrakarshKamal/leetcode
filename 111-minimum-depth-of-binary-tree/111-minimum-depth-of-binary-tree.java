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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        int level = 1;
        
        q.add(root);
        
        while (!q.isEmpty()) {
            
            int s = q.size();
            
            for (int i = 0; i < s; i++) {
                
                TreeNode curr = q.remove();
                
                if (curr.left == null && curr.right == null) {
                    return level;
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
        
        return level;
    }
}