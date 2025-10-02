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

class Pair {
    int idx;
    TreeNode node;

    Pair(TreeNode node, int idx) {
        this.node = node;
        this.idx = idx;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        int max = 0;
        if (root == null) return 0;
        q.offer(new Pair(root, 0)); // 0-based indexing

        while (!q.isEmpty()) {
            int size = q.size();
            int start = 0;
            int end = 0;
            
            for (int i = 0; i < size; i++) { 
                Pair p = q.poll();
                TreeNode curr = p.node;
                int currIdx = p.idx;
                if (i == 0) {
                    start = currIdx;
                }
                if (i == size - 1) {
                    end = currIdx;
                }

                if (curr.left != null) {
                    q.offer(new Pair(curr.left, (2*currIdx) + 1));
                }
                if (curr.right != null) {
                    q.offer(new Pair(curr.right, (2*currIdx) + 2));
                }
            }
            max = Math.max(max, (end - start) + 1);
        }
        return max;
    }
}