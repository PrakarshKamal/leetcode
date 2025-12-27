// DFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, 0, graph, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int currNode, int currColor, int[][] graph, int[] colors) {
        colors[currNode] = currColor;

        for (int neighbor : graph[currNode]) {
            if (colors[neighbor] == -1) {
                if (!dfs(neighbor, 1-currColor, graph, colors)) {
                    return false;
                }
            }
            else if (colors[neighbor] == currColor) {
                return false;
            }
        }
        return true;
    }
}