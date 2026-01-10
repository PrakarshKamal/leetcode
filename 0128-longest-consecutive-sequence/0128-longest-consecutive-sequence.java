// 
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        Arrays.sort(nums);
        int best = 1;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            else if (nums[i] == 1 + nums[i-1]) { // consecutive
                curr++;
                best = Math.max(best, curr);
            }
            else {
                curr = 1; // reset
            }
        }
        return best;
    }
}