/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

//TC : O(n)
//SC : O(1)

class Solution {
    public Node copyRandomList(Node head) {
        
        if (head == null) return null;
        
        Node node = head;
        
        // cloning LL as A -> A' -> B -> B' ...
        while (node != null) {
            Node clone = new Node(node.val);
            
            Node nxt = node.next;
            node.next = clone;
            
            clone.next = nxt;
        
            node = node.next.next;
        }
        
        //random pointers
        node = head;
        while (node != null) {
            
            if (node.random != null) {
                
                Node clone = node.next;
            
                clone.random = node.random.next;
            }
            
            node = node.next.next;
        }
        
        Node cloneHead = head.next;
        
        node = head;
        
        // undoing operations done in 1st while loop
        while (node != null) {
            
            Node clone = node.next;
            
            node.next = node.next.next;
            
            if (clone.next != null) {
                clone.next = clone.next.next;    
            }
            
            node = node.next;
        }
        
        return cloneHead;
    }
}