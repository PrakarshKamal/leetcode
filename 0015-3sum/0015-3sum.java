// Brute force O(n^3) time, O(n) space
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Set<List<Integer>> set = new HashSet<>();
//         Arrays.sort(nums);
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i+1; j < nums.length; j++) {
//                 for (int k = j+1; k < nums.length; k++) {
//                     if (nums[i] + nums[j] + nums[k] == 0) {
//                         List<Integer> curr = Arrays.asList(nums[i], nums[j], nums[k]);
//                         set.add(curr);
//                     }
//                 }
//             }
//         }
//         return new ArrayList<>(set);
//     }
// }

// Two pointers O(n^2) + O(nlogn) time
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum > 0) {
                    right--;
                }
                else if (threeSum < 0) {
                    left++;
                }
                else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (nums[left] == nums[left-1] && left < right) {
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}