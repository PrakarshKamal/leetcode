class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 2 sorting approaches
        // O(n log n) time, O(1) space
        // Arrays.sort(nums);
        // return nums[nums.length - k];
        
        // O(n log n) time, O(n) space
        // List<Integer> ans = new ArrayList<>(); 
        // for (int num : nums) { 
        //     ans.add(num); 
        // } 
        // Collections.sort(ans, Collections.reverseOrder()); 
        // return ans.get(k - 1); 

        // Min heap approach, O(n log k) time, O(k) space
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}