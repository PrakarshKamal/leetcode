class Solution {
    // Brute force O(n^2) time, O(1) space
    // public int[] twoSum(int[] nums, int target) {
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             int currSum = nums[i] + nums[j];
    //             if (currSum == target) {
    //                 return new int[] {i, j};
    //             }
    //         }
    //     }
    //     return new int[0];
    // }

    // HashMap O(n) time, O(n) space
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}