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
    
    private int preIndex;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        preIndex = 0;
        
        return buildTree(preorder, inorder, 0, inorder.length-1);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd) {
        
        // base
        if (inStart > inEnd) {
            return null;
        } 
        
        // rec
        int val = preorder[preIndex];
        int index = getIndex(inorder, val, inStart, inEnd);
        preIndex++;
        
        TreeNode root = new TreeNode(val);
        
        root.left = buildTree(preorder, inorder, inStart, index-1);
        root.right = buildTree(preorder, inorder, index+1, inEnd);
        
        return root;
        
    }
    
    private int getIndex(int[] arr, int val, int start, int end) {
        
        for (int i = start; i <= end; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
}