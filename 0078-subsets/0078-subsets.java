class Solution {
    // O(n * 2^n) time, O(n) space
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        backtrack(ans, temp, nums, 0);

        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
        // base case, add empty subset first
        if (start == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // we include the number
        temp.add(nums[start]);

        backtrack(ans, temp, nums, start + 1);

        // we don't include the number
        temp.remove(temp.size() - 1);

        backtrack(ans, temp, nums, start + 1);
    }
}