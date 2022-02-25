class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count = 0;
        int sum = 0;
        
        Map<Integer, Integer> result = new HashMap<>();
        
        // edge case when subarray empty
        result.put(0, 1);
        
        for (int a = 0; a < nums.length; a++) {
            sum += nums[a];
            
            if (result.containsKey(sum - k)) {
                count = count + result.get(sum - k);
            }
            result.put(sum, result.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
