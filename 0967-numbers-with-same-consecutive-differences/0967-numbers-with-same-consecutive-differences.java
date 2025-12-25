// // DFS
// class Solution {
//     public int[] numsSameConsecDiff(int n, int k) {
//         List<Integer> nums = new ArrayList<>();
//         for (int i = 1; i <= 9; i++) {
//             dfs(i, n-1, k, nums);
//         }
//         int[] ans = new int[nums.size()];
//         for (int i = 0; i < ans.length; i++) {
//             ans[i] = nums.get(i);
//         }
//         return ans;
//     }
//     public void dfs(int currNum, int n, int k, List<Integer> nums) {
//         if (n == 0) {
//             nums.add(currNum);
//             return;
//         }
//         int lastDigit = currNum % 10;
//         if (lastDigit + k <= 9) {
//             dfs(currNum*10 + lastDigit + k, n-1, k, nums);
//         }
//         if (k != 0 && lastDigit - k >= 0) {
//             dfs(currNum*10 + lastDigit - k, n-1, k, nums);
//         }
//     }
// }

// BFS
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            q.offer(i);
        }
        int lenOfCurrNum = 1;
        while (!q.isEmpty() && lenOfCurrNum < n) {
            int size = q.size();
            lenOfCurrNum++;
            for (int i = 0; i < size; i++) {
                int currNum = q.poll();
                int lastDigit = currNum % 10;
                if (lastDigit + k <= 9) {
                    q.offer(currNum*10 + lastDigit + k);
                }
                if (k != 0 && lastDigit - k >= 0) {
                    q.offer(currNum*10 + lastDigit - k);
                }
            }
        }
        while (!q.isEmpty()) {
            nums.add(q.poll());
        }
        int[] ans = new int[nums.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums.get(i);
        }
        return ans;
    }
}