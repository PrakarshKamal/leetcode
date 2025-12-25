// DFS
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n-1, k, nums);
        }
        int[] ans = new int[nums.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums.get(i);
        }
        return ans;
    }
    public void dfs(int currNum, int n, int k, List<Integer> nums) {
        if (n == 0) {
            nums.add(currNum);
            return;
        }
        int lastDigit = currNum % 10;
        if (lastDigit + k <= 9) {
            dfs(currNum*10 + lastDigit + k, n-1, k, nums);
        }
        if (k != 0 && lastDigit - k >= 0) {
            dfs(currNum*10 + lastDigit - k, n-1, k, nums);
        }
    }
}