class Solution {
    
    private List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        
        subSets(nums, 0, new ArrayList<>());
        
        return result;
        
    }
    
    private void subSets(int[] nums, int index, List<Integer> subset) {
        
        // base
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        
        // recurse
        
        // choose case
        subset.add(nums[index]); // action
        
        subSets(nums, index+1, subset); // recurse
        
        subset.remove(subset.size()-1); // backtrack
        
        // not choose
        subSets(nums, index+1, subset); // recurse
    }
}