class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valMap = new HashMap<>(); // value : index

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(valMap.containsKey(complement)) {
                return new int[] {valMap.get(complement), i};
            }
            valMap.put(nums[i], i);
        }
        return new int[0];
    }
}