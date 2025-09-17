class Solution {
    // Prefix Sum, O(n) time, O(1) space
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // we subtract pivot number nums[i] since 
            // its not included in right or left sum
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i]; // update leftSum as we iterate
        }
        return -1;
    }
}