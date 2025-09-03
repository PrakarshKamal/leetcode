class Solution {
    public boolean containsDuplicate(int[] nums) {
        // O(n) time, O(n) space
        // Set<Integer> seen = new HashSet<>();
        // for (int num : nums) {
        //     if (seen.contains(num)) {
        //         return true;
        //     }
        //     seen.add(num);
        // }
        // return false;


        // Map approach O(n) timne, O(n) space
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > 1) {
                return true;
            }
        }
        return false;
    }
}