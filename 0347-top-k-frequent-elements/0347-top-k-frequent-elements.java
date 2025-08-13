class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for (int key : map.keySet()) {
            int count = map.get(key); 
            if(bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(key);
        }

        int[] ans = new int[k];
        int idx = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if(bucket[i] != null) {
                for(int val : bucket[i]) {
                    ans[idx++] = val;
                    if(idx == k) {
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
}