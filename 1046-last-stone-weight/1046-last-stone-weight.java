class Solution {
    // Brute force sorting approach, O(n^2 log n) time, O(n) space
    // public int lastStoneWeight(int[] stones) {
    //     List<Integer> arr = new ArrayList<>();
    //     for (int stone : stones) {
    //         arr.add(stone);
    //     }

    //     while (arr.size() > 1) {
    //         Collections.sort(arr, Collections.reverseOrder());

    //         int y = arr.remove(0); // largest
    //         int x = arr.remove(0); // next largest
    //         int curr = y - x;

    //         if (curr != 0) {
    //             arr.add(curr);
    //         }
    //     }
        
    //     if (arr.isEmpty()) {
    //         return 0;
    //     }
    //     return arr.get(0);
    // }

    public int lastStoneWeight(int[] stones) {
        // Max heap approach, O(n log n) time, O(n) space
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // largest
            int x = maxHeap.poll(); // next largest
            int curr = y - x;

            if (curr != 0) {
                maxHeap.offer(curr);
            }
        }

        if (maxHeap.isEmpty()) {
            return 0;
        }
        return maxHeap.peek();
    }
}