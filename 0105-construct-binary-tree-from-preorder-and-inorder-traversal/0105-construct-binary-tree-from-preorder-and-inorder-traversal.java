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

    // Recursion, O(n) time, O(n) space
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode root = buildTreeHelper(preorder, 0, inorder.length - 1, inorderMap);

        return root;
    }

    private TreeNode buildTreeHelper(int[] preorder, int start, int end, Map<Integer, Integer> inorderMap) {

        // base/edge case, only build tree if start <= end
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;

        // get root which is at mid in map
        int mid = inorderMap.get(root.val);

        root.left = buildTreeHelper(preorder, start, mid - 1, inorderMap);

        root.right = buildTreeHelper(preorder, mid + 1, end, inorderMap);

        return root;
    }
}