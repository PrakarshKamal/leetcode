// O(n) time, O(1) space
class Solution {
    // public boolean canJump(int[] nums) {
    //     int n = nums.length;
    //     int canReach = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (i > canReach) { // to check even if is possible to reach
    //             return false;
    //         }
    //         canReach = Math.max(canReach, i + nums[i]);
    //     }
    //     return canReach >= n-1;
    // }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int canReach = n-1;
        for (int i = n-2; i >= 0; i--) {
            if (i + nums[i] >= canReach) { // keep moving left if can
                canReach = i;
            }
        }
        return canReach == 0;
    }
}