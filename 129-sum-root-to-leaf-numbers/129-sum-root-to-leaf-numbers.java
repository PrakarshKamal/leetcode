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
    
    // private int sum;
    
    public int sumNumbers(TreeNode root) {
        
        return sumNumbersRec(root, 0);

    }
    
    private int sumNumbersRec(TreeNode node, int num) {
        
        //base
        if (node == null) {
            return 0;
        }
        
        int currNum = num * 10 + node.val;
        
        //leaf
        if (node.left == null && node.right == null) {
            return currNum;
        }
        
        int leftSum = sumNumbersRec(node.left, currNum);
        int rightSum = sumNumbersRec(node.right, currNum);
        
        return leftSum + rightSum;
    }
}