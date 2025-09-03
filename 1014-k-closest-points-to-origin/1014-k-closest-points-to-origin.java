class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(distance(b), distance(a))); 

        if (k == points.length) {
            return points;
        }
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] ans = new int[maxHeap.size()][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            int[] point = maxHeap.poll();
            ans[i] = point;
            i++;
        }
        return ans;
    }

    private int distance(int[] point) {
        int x = point[0];
        int y = point[1];
        int euclid = x * x + y * y;
        return euclid;
    }
}