class KthLargest {

    // // Brute force with sorting
    // // O(n log n) time, O(n) space
    // List<Integer> ans;
    // int K;

    // public KthLargest(int k, int[] nums) {
    //     ans = new ArrayList<>();
    //     K = k;

    //     for (int num : nums) {
    //         ans.add(num);
    //     }
    // }
    
    // public int add(int val) {
    //     // We add val to arr and sort
    //     ans.add(val);
    //     // Sort in reverse order (descending) meaning kth largest would be in beginning of array
    //     Collections.sort(ans, Collections.reverseOrder());
    //     return ans.get(K - 1); // index would be K - 1 since 0-indexed

    //     // if we did ascending order
    //     // Collections.sort(arr);
    //     // return arr.get(arr.size() - 1) since kth largest is now at end of array
    // }

    // Min Heap approach O(n log k) time for building heap, O(k) space since we store k elements in min heap
    PriorityQueue<Integer> minHeap;
    int K;

    public KthLargest(int k, int[] nums) {
        K = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > K) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > K) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */