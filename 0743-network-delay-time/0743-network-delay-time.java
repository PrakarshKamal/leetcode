// Bellman-Ford O(V*E), E is V*V^2 so O(V^3) time, O(V) space
// class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
//         int[] dist = new int[n+1]; // to offset 1-indexing
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[k] = 0;

//         for (int i = 0; i < n; i++) { // n-1 relaxations
//             for (int[] edge : times) {
//                 int u = edge[0];
//                 int v = edge[1];
//                 int w = edge[2];
//                 if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
//                     dist[v] = dist[u] + w;
//                 }
//             }
//         }
//         int ans = -1;
//         for (int i = 1; i <= n; i++) {
//             ans = Math.max(ans, dist[i]); // take max as its largest in dist which is minimum
//         } 
//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
// }

// Dijkstra O(V + ElogV) time, O(V+E) space
// class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
//         List<List<int[]>> graph = new ArrayList<>();
//         for (int i = 0; i <= n; i++) {
//             graph.add(new ArrayList<>());
//         }

//         int[] dist = new int[n+1];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[k] = 0;

//         for (int[] time : times) {
//             graph.get(time[0]).add(new int[] {time[1], time[2]}); // node, weight
//         }

//         PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
//         pq.offer(new int[] {0, k}); // dist, node

//         while (!pq.isEmpty()) {
//             int[] curr = pq.poll();
//             int currDist = curr[0];
//             int currNode = curr[1];
//             for (int[] neighbor : graph.get(currNode)) {
//                 int adjNode = neighbor[0];
//                 int adjDist = neighbor[1];
//                 if (currDist + adjDist < dist[adjNode]) { // only enqueue if smaller distance found
//                     dist[adjNode] = currDist + adjDist;
//                     pq.offer(new int[] {dist[adjNode], adjNode});
//                 }
//             }
//         }
//         int ans = -1;
//         for (int i = 1; i <= n; i++) {
//             ans = Math.max(ans, dist[i]);
//         }
//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
// }

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