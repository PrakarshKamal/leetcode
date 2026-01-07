// Sliding Window O(n) time, O(1) space
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left);
        }
        return maxLen;
    }
}