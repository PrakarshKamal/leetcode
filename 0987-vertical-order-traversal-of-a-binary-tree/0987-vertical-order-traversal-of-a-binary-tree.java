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

class State {
    TreeNode node;
    int row;
    int col;

    State(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

// BFS + Sorting O(n) + O(nlogn) time, O(n) space
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Map<Integer, List<State>> map = new TreeMap<>();
        Queue<State> q = new LinkedList<>();
        q.offer(new State(root, 0, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                State curr = q.poll();
                map.computeIfAbsent(curr.col, k -> new ArrayList<>()).add(curr);

                if (curr.node.left != null) {
                    q.offer(new State(curr.node.left, curr.row+1, curr.col-1));
                }
                if (curr.node.right != null) {
                    q.offer(new State(curr.node.right, curr.row+1, curr.col+1));
                }
            }
        }

        for (List<State> entry : map.values()) {
            entry.sort((a, b) -> { // sort by row then value
                if (a.row != b.row) {
                    return Integer.compare(a.row, b.row);
                }
                return Integer.compare(a.node.val, b.node.val);
            });

            List<Integer> colVals = new ArrayList<>();
            for (State s : entry) {
                colVals.add(s.node.val);
            }
            ans.add(colVals);
        }
        return ans;
    }
}