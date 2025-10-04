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
    private int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode root = buildTreeHelper(postorder, 0, inorder.length - 1, inorderMap);

        return root;
    }

    private TreeNode buildTreeHelper(int[] postorder, int start, int end, Map<Integer, Integer> inorderMap) {

        // base/edge case, only build tree if start <= end
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;

        // get root which is at mid in map
        int mid = inorderMap.get(root.val);

        root.right = buildTreeHelper(postorder, mid + 1, end, inorderMap);

        root.left = buildTreeHelper(postorder, start, mid - 1, inorderMap);

        return root;
    }
}