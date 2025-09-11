class Solution {
    // Kadane's algo, O(n) time, O(1) space
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // or set to nums[0]
        int currSum = 0;
        for (int num : nums) {
            // if currSum ever negative, we reset to 0 since we     
            // don't  wanna add a negative sum to further elems
            currSum = Math.max(currSum, 0); 
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}