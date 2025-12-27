// DFS
// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
//         int[] colors = new int[n];
//         Arrays.fill(colors, -1);

//         for (int i = 0; i < n; i++) {
//             if (colors[i] == -1) {
//                 if (!dfs(i, 0, graph, colors)) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
//     public boolean dfs(int currNode, int currColor, int[][] graph, int[] colors) {
//         colors[currNode] = currColor;

//         for (int neighbor : graph[currNode]) {
//             if (colors[neighbor] == -1) {
//                 if (!dfs(neighbor, 1-currColor, graph, colors)) {
//                     return false;
//                 }
//             }
//             else if (colors[neighbor] == currColor) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!bfs(i, 0, graph, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int currNode, int currColor, int[][] graph, int[] colors) {
        Queue<Integer> q = new LinkedList<>();
        colors[currNode] = currColor;
        q.offer(currNode);

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            for (int neighbor : graph[frontNode]) {
                if (colors[neighbor] == -1) {
                    colors[neighbor] = 1-colors[frontNode];
                    q.offer(neighbor);
                }
                else if (colors[neighbor] == colors[frontNode]) {
                    return false;
                }
            }
        }
        return true;
    }
}