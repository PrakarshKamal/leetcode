// BFS
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int i = q.poll();
            if (arr[i] == 0) {
                return true; // found way to reach
            }

            int jump1 = i + arr[i];
            if (jump1 < n && !visited[jump1]) {
                visited[jump1] = true;
                q.offer(jump1);
            }
            
            int jump2 = i - arr[i];
            if (jump2 >= 0 && jump2 < n && !visited[jump2]) {
                visited[jump2] = true;
                q.offer(jump2);
            }
        }
        return false;
    }
}