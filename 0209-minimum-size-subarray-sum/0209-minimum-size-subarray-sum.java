class Solution {
    // Sliding Window O(n) time, O(1) space
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, currSum = 0;
        int length = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];
            while (currSum >= target) {
                // calculate new minimum length
                length = Math.min(right - left + 1, length);
                // drop left most value from currSum to move window right
                currSum -= nums[left]; 
                left++;
            }
        }
        if (length == Integer.MAX_VALUE) {
            return 0;
        }
        return length;
    }
}