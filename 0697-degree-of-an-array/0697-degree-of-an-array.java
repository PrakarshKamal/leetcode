class Solution {
    public int findShortestSubArray(int[] nums) {
        int degree = 0;
        int minLength = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> seenMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            seenMap.putIfAbsent(nums[i], i);
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);

            if (degree < freqMap.get(nums[i])) {
                degree = freqMap.get(nums[i]);
                minLength = i - seenMap.get(nums[i]) + 1;
            }
            else if (degree == freqMap.get(nums[i])) {
                minLength = Math.min(minLength, i - seenMap.get(nums[i]) + 1);
            }
        }
        return minLength;
    }
}