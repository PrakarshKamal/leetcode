class Solution {
    // Prefix Sum, O(n) time, O(n) space
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // edge case

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int difference = currSum - k;

            if (map.containsKey(difference)) {
                ans += map.get(difference);
            }

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return ans;
    }
}