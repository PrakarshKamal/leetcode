class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            ans.add(num);
        }

        Collections.sort(ans, Collections.reverseOrder());

        return ans.get(k - 1);
    }
}