class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> (b - a)
        );
        
        for(int[] nums : matrix) {
            for(int num : nums) {
                pq.add(num);
                
                if (pq.size() > k) {
                   pq.remove();
                }
            }
        }
        
        return pq.poll();
    }
}