class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int bestSum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = n-1;
            
            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right]; 
                int currDiff = Math.abs(currSum - target);
                int bestDiff = Math.abs(bestSum - target);

                if (currDiff < bestDiff) {
                    bestSum = currSum;
                }

                if (currSum == target) {
                    return currSum; // found so we return
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