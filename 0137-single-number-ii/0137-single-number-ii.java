// O(n) time, O(n) space
// class Solution {
//     public int singleNumber(int[] nums) {
//         int ans = 0;
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int i = 0; i < nums.length; i++) {
//             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//         }
//         for (Map.Entry<Integer, Integer> e : map.entrySet()) {
//             int freq = e.getValue();
//             if (freq == 1) {
//                 ans = e.getKey();
//             }
//         }
//         return ans;
//     }
// }

// Bit manipulation O(n) time, O(1) space
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                ans = ans | (1 << i);
            }
        }
        return ans;
    }
}