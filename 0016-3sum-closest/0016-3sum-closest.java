// Two pointers O(n^2) + O(nlogn) time
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int bestSum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = n-1;

            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right]; 
            
                if (Math.abs(currSum-target) < Math.abs(bestSum-target)) {
                    bestSum = currSum;
                }

                if (currSum == target) {
                    return currSum; // found so we return early
                }

                else if (currSum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return bestSum;
    }
}