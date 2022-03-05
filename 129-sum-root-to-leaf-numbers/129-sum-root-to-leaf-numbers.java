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
    
    private int sum;
    
    public int sumNumbers(TreeNode root) {
        
        sum = 0;
        
        sumNumbersRec(root, 0);
        
        return sum;
    }
    
    private void sumNumbersRec(TreeNode node, int num) {
        
        //base
        if (node == null) {
            return;
        }
        
        int currNum = num * 10 + node.val;
        
        //leaf
        if (node.left == null && node.right == null) {
            sum += currNum;
        }
        
        sumNumbersRec(node.left, currNum);
        sumNumbersRec(node.right, currNum);
    }
}