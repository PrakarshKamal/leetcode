class Solution {
    public int findPairs(int[] nums, int k) {
        
        // can't have abs diff less than 0 or arr empty
        if (k < 0 || nums.length == 0) {
            return 0;
        }
        
        // we store elements in num as KEY
        // and their count as VALUE
        Map<Integer, Integer> map = new HashMap<>();
        
        int count = 0;
        
        for (int num : nums) {
            map.put (num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int i : map.keySet()) {
            
            if (k == 0) {
                if (map.get(i) >= 2) {
                    count++;
                }
            }
            else {
                if (map.containsKey(i + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}