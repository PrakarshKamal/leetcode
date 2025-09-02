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
    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        dfs(root, 0, targetSum, new ArrayList<>());

        return ans;
    }

    private void dfs(TreeNode root, int currSum, int targetSum, List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        currSum += root.val;

        if (root.left == null && root.right == null && currSum == targetSum) {
            ans.add(new ArrayList<>(path));
        }


        dfs(root.left, currSum, targetSum, path);
        dfs(root.right, currSum, targetSum, path);

        path.remove(path.size() - 1);
    }
}