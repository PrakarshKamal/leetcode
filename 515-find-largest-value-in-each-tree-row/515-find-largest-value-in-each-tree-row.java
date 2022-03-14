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
    
    List<Integer> result;
    Queue<TreeNode> q;
    
    public List<Integer> largestValues(TreeNode root) {
        
        result = new ArrayList<>();
        q = new LinkedList<>();
        
        if (root == null) {
            return result;
        }
        
        q.add(root);
        
        while (!q.isEmpty()) {
            
            int max = Integer.MIN_VALUE;
            int s = q.size();
            
            for (int i = 0; i < s; i++) {
                
                TreeNode temp = q.remove();
                
                // comparing current val with max
                if (temp.val > max) {
                    max = temp.val;
                }
                
                // adding left child
                if (temp.left != null) {
                    q.add(temp.left);
                }
                
                // adding right child
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}