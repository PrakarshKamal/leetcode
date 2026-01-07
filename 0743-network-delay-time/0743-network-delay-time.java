// Floyd Warshall O(V^3) time, O(V^2) space
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] dist = new int[n+1][n+1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 1; i <= n; i++) {
            dist[i][i] = 0; // diagonals will be 0
        }
        for (int[] edge : times) { // initializing edges -> form adj matrix
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
        }
        
        for (int mid = 1; mid <= n; mid++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][mid] != Integer.MAX_VALUE && dist[mid][j] != Integer.MAX_VALUE) {
                        if (dist[i][mid] + dist[mid][j] < dist[i][j]) {
                            dist[i][j] = dist[i][mid] + dist[mid][j];
                        }
                    }
                }
            }
        }
        int ans = -1;
        int src = k;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[src][i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}