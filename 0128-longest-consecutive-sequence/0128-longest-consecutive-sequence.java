// Sorting O(n log n) time, O(1) space
// class Solution {
//     public int longestConsecutive(int[] nums) {
//         int n = nums.length;
//         if (n == 0) return 0;

//         Arrays.sort(nums);
//         int best = 1;
//         int curr = 1;
//         for (int i = 1; i < n; i++) {
//             if (nums[i] == nums[i-1]) {
//                 continue;
//             }
//             else if (nums[i] == 1 + nums[i-1]) { // consecutive
//                 curr++;
//                 best = Math.max(best, curr);
//             }
//             else {
//                 curr = 1; // reset
//             }
//         }
//         return best;
//     }
// }

// O(n) time, O(n) space
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int best = 1;
        for (int num : set) {
            if (set.contains(num-1)) { // can't be start of sequence
                continue;
            }
            else {
                int len = 1;
                while (set.contains(num+len)) {
                    len++;
                    best = Math.max(best, len);
                }
            }
        }
        return best;
    }
}