class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length-2; i++) {
            
            int left = i+1;
            int right = nums.length-1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                if (currentSum == 0) {
                    List<Integer> tmp = Arrays.asList(nums[i], nums[left], nums[right]);
                    
                    Collections.sort(tmp);
                    
                    res.add(tmp);
                    
                    ++left;
                    --right;
                    
                    while(left < right && nums[left] == nums[left-1]) {
                        ++left;
                    }
                    
                    while (left < right && nums[right] == nums[right+1]) {
                        --right;
                    }
                }
                else if (currentSum < 0) {
                    ++left;
                }
                else {
                    --right;
                }
            }
            
            while (i < nums.length-2 && nums[i] == nums[i+1]) {
                ++i;
            }
        }
            
        return res;
    }
}