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
    // Recursive approach O(n) time, O(n) space
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     if (p == null && q == null) {
    //         return true;
    //     }
    //     if (p == null || q == null || p.val != q.val) {
    //         return false;
    //     }
    //     return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    // }
    
    // Iterative DFS O(n) time, O(n) space
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(p);
        q2.add(q);
        
        while (q1.size() > 0 && q2.size() > 0) {
            int s1 = q1.size();
            int s2 = q2.size();
            if (s1 != s2) {
                return false;
            }

            for (int i = 0; i < s1; i++) {
                TreeNode qNode = q1.poll();
                TreeNode pNode = q2.poll();

                if (pNode == null && qNode == null) {
                    continue;
                }

                if (qNode == null || pNode == null) {
                    return false;
                }
                if (qNode.val != pNode.val) {
                    return false;
                }

                q1.add(qNode.left);
                q1.add(qNode.right);
                q2.add(pNode.left);
                q2.add(pNode.right);
            }
        } 
        return q1.isEmpty() && q2.isEmpty();   
    }
}