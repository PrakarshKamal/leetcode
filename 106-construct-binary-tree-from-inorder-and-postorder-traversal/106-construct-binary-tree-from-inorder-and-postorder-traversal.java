// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
        
//     public TreeNode buildTree(int[] inorder, int[] postorder) {

//         return buildTreeRec(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
//     }
    
//     private TreeNode buildTreeRec(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        
//         //base
//         if (postStart > postEnd) {
//             return null;
//         }
        
//         // rec
//         int val = postorder[postEnd];

//         int index = 0;
        
//         for (int i = inStart; i <= inEnd; i++) {
//             if (inorder[i] == val) {
//                 index = i;
//                 break;
//             }
//         }     
        
//         int shift = index - inStart;
        
//         TreeNode root = new TreeNode(val);
        
//         root.left = buildTreeRec(postorder, inorder, inStart, index-1, postStart, postStart + shift - 1);
//         root.right = buildTreeRec(postorder, inorder, index+1, inEnd, postStart + shift, postEnd-1);

        
//         return root; 
//     }
// }

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {

        if (postStart > postEnd) {
            return null;
        }

        // current root is the last node of postorder array
        int rootVal = postorder[postEnd];

        // find the index of current root in inorder array
        // can use hashmap to cache the location of the nodes
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);

        // recursively build the left subtree and right subtree
        root.left = build(postorder, postStart, postStart + leftSize - 1, inorder, inStart, index - 1);
        root.right = build(postorder, postStart + leftSize, postEnd - 1, inorder, index + 1, inEnd);

        return root;
    }
}  