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

class Solution {
    public Node connect(Node root) {
        connectRecursive(root, null);
        return root;
    }
    
    private void connectRecursive(Node node, Node next) {
        
        // base
        if (node == null) {
            return;
        }
        
        node.next = next;
        
        connectRecursive(node.left, node.right);
        connectRecursive(node.right, node.next == null ? null : node.next.left);
    }
}