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

// brute force O(n) time, O(n) space
// class Solution {
//     public int[] findMode(TreeNode root) {
//         Map<Integer, Integer> map = new HashMap<>();
//         inorder(root, map);

//         int mode = 0;
//         for (Integer count : map.values()) {
//             mode = Math.max(mode, count);
//         }

//         List<Integer> curr = new ArrayList<>();
//         for (Map.Entry<Integer, Integer> e : map.entrySet()) {
//             if (e.getValue() == mode) {
//                 curr.add(e.getKey());
//             }
//         }

//         int[] ans = new int[curr.size()];
//         for (int i = 0; i < curr.size(); i++) {
//             ans[i] = curr.get(i);
//         }
//         return ans;
//     }

//     public void inorder(TreeNode root, Map<Integer, Integer> map) {
//         if (root == null) return;

//         inorder(root.left, map);
//         map.put(root.val, map.getOrDefault(root.val, 0)+1);
//         inorder(root.right, map);
//     }
// }

class Solution {

    Integer prev = null;
    int currCount = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        inorder(root, modes);

        int[] ans = new int[modes.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = modes.get(i);
        }
        return ans;
    }

    public void inorder(TreeNode root, List<Integer> modes) {
        if (root == null) return;

        inorder(root.left, modes);

        if (prev != null && root.val == prev) {
            currCount++;
        }
        else {
            currCount = 1;
        }

        if (currCount > maxCount) {
            maxCount = currCount;
            modes.clear();
            modes.add(root.val);
        }
        else if (currCount == maxCount) {
            modes.add(root.val);
        }
        prev = root.val;

        inorder(root.right, modes);
    }
}