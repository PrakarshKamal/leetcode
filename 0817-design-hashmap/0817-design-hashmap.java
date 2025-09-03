// Singly Linked List Node
class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMap {

    Node[] table;
    final int PRIME = 1051; // big prime number

    // O(n) time, O(n) space
    public MyHashMap() {
        table = new Node[PRIME];
    }

    private int hashFunction(int key) {
        return key % PRIME;
    }
    
    public void put(int key, int value) {
        int index = hashFunction(key);
        Node node = table[index];

        if (node == null) {
            table[index] = new Node(key, value);
        }
        else {
            Node prev = null;
            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node(key, value);
        }
    }
    
    public int get(int key) {
        int index = hashFunction(key);
        Node node = table[index];

        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hashFunction(key);
        Node node = table[index];
        Node prev = null;

        while (node != null) {
            if (node.key == key) {
                if (prev != null) {
                    prev.next = node.next;
                }
                else {
                    table[index] = node.next;
                }
                return;
            }
            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */