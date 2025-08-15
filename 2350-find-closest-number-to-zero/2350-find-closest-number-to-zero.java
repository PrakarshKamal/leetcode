class Solution {
    public int findClosestNumber(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < smallest) {
                smallest = Math.abs(nums[i]);
                ans = nums[i];
            }
            else if (Math.abs(nums[i]) == smallest) {
                ans = Math.max(ans, nums[i]);
            }
        }
        return ans;
    }
}