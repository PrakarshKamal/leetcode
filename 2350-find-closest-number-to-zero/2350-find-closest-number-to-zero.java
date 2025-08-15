class Solution {
    public int findClosestNumber(int[] nums) {
        int currSmallest = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < currSmallest) {
                currSmallest = Math.abs(nums[i]);
                ans = nums[i];
            }
            else if (Math.abs(nums[i]) == currSmallest) {
                ans = Math.max(ans, nums[i]);
            }
        }
        return ans;
    }
}