/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // BFS Level Order Traversal O(n) time, O(n) space

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                ans.append("N,"); // N represents null
                continue;
            }
            ans.append(curr.val + ",");
            q.offer(curr.left);
            q.offer(curr.right);
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;

        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < values.length) {
            TreeNode curr = q.poll();
            if (!values[i].equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                curr.left = left;
                q.offer(left);
            }
            i++;

            if (!values[i].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                curr.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));