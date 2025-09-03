class Solution {
    // Max heap approach O(n log k) time, O(k) space
    public int[][] kClosest(int[][] points, int k) {
        // We have to use Integer.compare as we have int[] in heap
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(distance(b), distance(a))); 

        //
        if (k == points.length) {
            return points;
        }
        
        // Build max heap 
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) { // only maintain at most k points
                maxHeap.poll();
            }
        }

        int[][] ans = new int[maxHeap.size()][2];
        int i = 0;
        // build answer by polling the heap and setting to ans
        while (!maxHeap.isEmpty()) {
            int[] point = maxHeap.poll();
            ans[i] = point;
            i++;
        }
        return ans;
    }

    // helper for computing distance, don't need to sqrt
    private int distance(int[] point) {
        int x = point[0];
        int y = point[1];
        int euclid = x * x + y * y;
        return euclid;
    }
}