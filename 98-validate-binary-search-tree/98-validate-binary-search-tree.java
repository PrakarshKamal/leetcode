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
    
    private List<Integer> bst;
    
    
    public boolean isValidBST(TreeNode root) {
        
        bst = new ArrayList<>();
        
        validateBST(root);
        
        for (int i = 1; i < bst.size(); i++) {
            if (bst.get(i) <= bst.get(i-1)) {
                return false;
            }
        }
        
        return true;
    }
    
    private void validateBST(TreeNode node) {
        
        // base
        if (node == null) {
            return;
        }
        
        // left
        validateBST(node.left);
        
        // node
        bst.add(node.val);
        
        // right
        validateBST(node.right);
    }
}