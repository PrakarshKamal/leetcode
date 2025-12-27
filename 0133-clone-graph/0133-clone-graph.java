/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// DFS O(V+E) time, O(V+E) space
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    public Node dfs(Node node, Map<Node, Node> map) {
        if (node == null) return null;
        Node cloned = new Node(node.val);
        map.put(node, cloned);

        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                cloned.neighbors.add(dfs(neighbor, map));
            }
            else {
                cloned.neighbors.add(map.get(neighbor));
            }
        }
        return cloned;
    }
}