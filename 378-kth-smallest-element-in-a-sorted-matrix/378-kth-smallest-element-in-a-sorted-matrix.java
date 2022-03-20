class Solution {
    
    // TC: O(n log k)
    // SC: O(k)
    
    public int kthSmallest(int[][] matrix, int k) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> (b - a) // comparator for max heap
        );
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);
                
                if (pq.size() > k) {
                   pq.remove();
                }
            }
        }
        return pq.remove();
    }
}