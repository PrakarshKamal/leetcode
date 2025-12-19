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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();

        if (start > end) { // base case => empty tree
            ans.add(null);
            return ans;
        }

        if (start == end) { // 1 node
            ans.add(new TreeNode(start));
            return ans;
        }

        List<TreeNode> leftTrees;
        List<TreeNode> rightTrees;

        // i is root
        for (int i = start; i <= end; i++) {
            leftTrees = helper(start, i-1); // populate left subtrees list
            rightTrees = helper(i+1, end); // populate right subtrees list
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}