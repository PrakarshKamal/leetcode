class Solution {
    
    // Recursive Backtracking O(n * 2^n) time, O(n) space
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();

        comboSum(candidates, 0, target, new ArrayList<>());

        return ans;
    }

    private void comboSum(int[] candidates, int idx, int target, List<Integer> combos) {
        if (target < 0 || idx == candidates.length) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(combos));
            return;
        }

        // we choose index
        combos.add(candidates[idx]);

        comboSum(candidates, idx, target - candidates[idx], combos);

        // backtrack
        combos.remove(combos.size() - 1);

        // don't choose index
        comboSum(candidates, idx + 1, target, combos);
    }
}