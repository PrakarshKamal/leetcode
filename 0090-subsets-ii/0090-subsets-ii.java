class Solution {

    Set<List<Integer>> seen = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(subset, nums, 0);

        return new ArrayList<>(seen);
    }

    public void backtrack(List<Integer> subset, int[] nums, int start) {
        // base case, add empty subset first to Set
        if (start == nums.length) {
            seen.add(new ArrayList<>(subset));
            return;
        }

        // we include the number
        subset.add(nums[start]);

        backtrack(subset, nums, start + 1);

        // we don't include the number
        subset.remove(subset.size() - 1);

        backtrack(subset, nums, start + 1);
    }
}