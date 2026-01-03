// BFS O(n) time, O(n) space
// class Solution {
//     public boolean canReach(int[] arr, int start) {
//         int n = arr.length;
//         boolean[] visited = new boolean[n];
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(start);
//         visited[start] = true;

//         while (!q.isEmpty()) {
//             int i = q.poll();
//             if (arr[i] == 0) return true; // found way to reach
            
//             int jump1 = i + arr[i]; // jump1 is i (index)
//             if (jump1 < n && !visited[jump1]) {
//                 visited[jump1] = true;
//                 q.offer(jump1);
//             }
            
//             int jump2 = i - arr[i]; // jump2 is i (index)
//             if (jump2 >= 0 && !visited[jump2]) {
//                 visited[jump2] = true;
//                 q.offer(jump2);
//             }
//         }
//         return false;
//     }
// }

// DFS O(n) time, O(n) space
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];

        visited[start] = true;
        if (!dfs(start, n, arr, visited)) {
            return false;
        }
        return true;
    }
    public boolean dfs(int i, int n, int[] arr, boolean[] visited) {
        if (arr[i] == 0) return true; // base case, found way to reach

        int jump1 = i + arr[i];
        if (jump1 < n && !visited[jump1]) {
            visited[jump1] = true;
            if (dfs(jump1, n, arr, visited)) return true;
        }
        int jump2 = i - arr[i];
        if (jump2 >= 0 && !visited[jump2]) {
            visited[jump2] = true;
            if (dfs(jump2, n, arr, visited)) return true;
        }
        return false;
    }
}