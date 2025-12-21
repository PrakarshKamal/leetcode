class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int product = 1;
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            }
            else {
                product *= nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeros > 1) {
                ans[i] = 0;
            }
            else if (zeros == 1) {
                ans[i] = nums[i] == 0 ? product : 0;
            }
            else {
                ans[i] = product / nums[i];
            }
        }
        return ans;
    }
}