// DFS
// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int n = isConnected.length;
//         boolean[] visited = new boolean[n];
//         int count = 0;
//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 count++;
//                 visited[i] = true;
//                 dfs(i, n, isConnected, visited);
//             }
//         }
//         return count;
//     }
//     public void dfs(int currCity, int n, int[][] isConnected, boolean[] visited) {
//         for (int i = 0; i < n; i++) {
//             if (isConnected[currCity][i] == 1 && !visited[i]) {
//                 visited[i] = true;
//                 dfs(i, n, isConnected, visited);
//             }
//         }
//     }
// }

// BFS
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                q.offer(i);

                while (!q.isEmpty()) {
                    int currCity = q.poll();
                    visited[currCity] = true;

                    for (int neighbor = 0; neighbor < n; neighbor++) {
                        if (isConnected[currCity][neighbor] == 1 && !visited[neighbor]) {
                            q.offer(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                }
            }
        }
        return count;
    }
}