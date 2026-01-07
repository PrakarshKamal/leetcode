class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for (int i = 0; i <= k; i++) {
            // temp -> curr iteration updates cost
            // cost -> prev iteration
            int[] temp = cost.clone();
            for (int[] edge : flights) {
                int from = edge[0];
                int to = edge[1];
                int price = edge[2];
                if (cost[from] != Integer.MAX_VALUE && price + cost[from] < temp[to]) {
                    temp[to] = price + cost[from];
                }
            }
            cost = temp;
        }
        int ans = cost[dst];
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}