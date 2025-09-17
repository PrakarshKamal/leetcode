class Solution {
    // Two Pointers O(n) time, O(1) space
    public int removeDuplicates(int[] nums) {
        int left = 1;
        int count = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] == nums[right - 1]) {
                count++;
            }
            else {
                count = 1;
            }

            if (count <= 2) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}