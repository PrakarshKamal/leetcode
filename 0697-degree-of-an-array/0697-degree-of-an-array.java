class Solution {
    // Solution 1, Two Maps O(n) time, O(n) space
    // public int findShortestSubArray(int[] nums) {
    //     int degree = 0;
    //     int minLength = 0;
    //     Map<Integer, Integer> freqMap = new HashMap<>();
    //     Map<Integer, Integer> seenMap = new HashMap<>();

    //     for (int i = 0; i < nums.length; i++) {
    //         seenMap.putIfAbsent(nums[i], i);
    //         freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);

    //         if (degree < freqMap.get(nums[i])) {
    //             degree = freqMap.get(nums[i]);
    //             minLength = i - seenMap.get(nums[i]) + 1; // add one to offset 0-based indexing
    //         }
    //         else if (degree == freqMap.get(nums[i])) {
    //             minLength = Math.min(minLength, i - seenMap.get(nums[i]) + 1);
    //         }
    //     }
    //     return minLength;
    // }


    // Solution 2 One Map O(n) time, O(n) space
    public int findShortestSubArray(int[] nums) {
        int degree = 0;
        int minLength = nums.length;
        // int[] is [firstOccurrence, lastOccurrence, count]
        Map<Integer, int[]> map = new HashMap<>(); 

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[] {i, i, 1});
            }
            else {
                int[] arr = map.get(nums[i]);
                arr[1] = i;
                arr[2]++;
                map.put(nums[i], arr);
            }
        }
        for (int[] value : map.values()) {
            if (value[2] > degree) {
                degree = value[2];
                minLength = value[1] - value[0] + 1;
            }
            else if (value[2] == degree) {
                minLength = Math.min(minLength, value[1] - value[0] + 1);
            }
        }
        return minLength;
    }
}