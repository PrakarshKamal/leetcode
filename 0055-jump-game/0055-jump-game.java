class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int canReach = 0;
        for (int i = 0; i < n; i++) {
            if (i > canReach) { // to check even if is possible to reach
                return false;
            }
            canReach = Math.max(canReach, i + nums[i]);
        }
        return canReach >= n-1;
    }
}