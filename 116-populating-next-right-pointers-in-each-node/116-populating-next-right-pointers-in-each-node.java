/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// TC : O(n)
// SC: O(height of tree (log n)) but recursive stack space is ignored so SC = O(1)

class Solution {
//     public Node connect(Node root) {
//         connectRecursive(root, null);
//         return root;
//     }
    
//     private void connectRecursive(Node node, Node next) {
        
//         // base
//         if (node == null) {
//             return;
//         }
        
//         node.next = next;
        
//         connectRecursive(node.left, node.right);
//         connectRecursive(node.right, node.next == null ? null : node.next.left);
//     }
    
    // TC: O(n)
    // SC: O(1) (no extra recursive stack space)
    public Node connect(Node root) {
        
        if (root == null) {
            return root;
        }
        
        Node leftMost = root;
        
        while (leftMost.left != null) {
            Node prev = leftMost;
            Node curr = prev.left;
            
            while (curr != null) {
                
                curr.next = prev.right;
                curr = curr.next;
                
                if (prev.next != null) {
                    curr.next = prev.next.left;
                }
                
                curr = curr.next;
                prev = prev.next;
            }
  
            leftMost = leftMost.left;
        }
        
        return root;
    }
}
