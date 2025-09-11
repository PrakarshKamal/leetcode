class Solution {
    // Kadane's algo, O(n) time, O(1) space
    public int maxProduct(int[] nums) {
        int maxProd = nums[0]; // global max prod
        int currMax = nums[0]; // max product ending at the current index
        int currMin = nums[0]; // min product ending at the current index
        for (int i = 1; i < nums.length; i++) {
            // we perform swap since currMax could
            // become new currMin if we multiply by negative num
            // or currMin could become new currMax if we multiply       
            // 2 negatives together to get larger positive
            if (nums[i] < 0) {
                int temp = currMax; 
                currMax = currMin; 
                currMin = temp;
            }
            currMax = Math.max(nums[i], nums[i] * currMax);
            currMin = Math.min(nums[i], nums[i] * currMin);
            maxProd = Math.max(maxProd, currMax);
        }
        return maxProd;
    }
}