// DFS Adjacency Matrix
// class Solution {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         int[][] graph = new int[n][n]; // n*n matrix
//         boolean[] visited = new boolean[n];
//         for (int[] edge : edges) {
//             int u = edge[0];
//             int v = edge[1];
//             graph[u][v] = 1;
//             graph[v][u] = 1;
//         }
//         return dfs(n, graph, source, destination, visited);
//     }
//     public boolean dfs(int n, int[][] graph, int source, int destination, boolean[] visited) {
//         if (source == destination) return true; // base case
//         visited[source] = true;
//         for (int i = 0; i < n; i++) { // row of source to find neighbors
//             if (graph[source][i] == 1 && !visited[i]) { // i is neighbor of source
//                 if (dfs(n, graph, i, destination, visited)) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

// BFS Adjacency Matrix
// class Solution {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         int[][] graph = new int[n][n]; // n*n matrix
//         boolean[] visited = new boolean[n];
//         for (int[] edge : edges) {
//             int u = edge[0];
//             int v = edge[1];
//             graph[u][v] = 1;
//             graph[v][u] = 1;
//         }
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(source);
//         visited[source] = true;

//         while (!q.isEmpty()) {
//             int curr = q.poll();
//             if (curr == destination) return true;
//             for (int i = 0; i < n; i++) {
//                 if (graph[curr][i] == 1 && !visited[i]) {
//                     q.offer(i);
//                     visited[i] = true;
//                 }
//             }
//         }
//         return false;
//     }
// }

// DFS Adjacency List
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, value -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, value -> new ArrayList<>()).add(u);
        }
        return dfs(graph, source, destination, visited);
    }
    public boolean dfs(Map<Integer, List<Integer>> graph, int source, int destination, boolean[] visited) {
        if (source == destination) return true;
        visited[source] = true;
        for (int neighbor : graph.get(source)) {
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor, destination, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}