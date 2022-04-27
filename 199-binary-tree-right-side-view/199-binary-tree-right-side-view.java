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

// Time Complexity : O(n) where n is # of nodes
// Space Complexity : O(n) where n is # of nodes

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        //edge check
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while (!q.isEmpty()) {
            int sz = q.size();
            
            for (int i = 0; i < sz; i++) {
                
                TreeNode curr = q.remove();
                
                if (i == sz - 1) {
                    result.add(curr.val);
                }
                
                if (curr.left != null) {
                    q.add(curr.left);
                }
                
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        
        return result;
    }
}