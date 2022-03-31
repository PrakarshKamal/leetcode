class Solution {
    
    private int[] dp;
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        dp = new int[arr.length];
        Arrays.fill(dp, -1); // initialize dp arr with -1
        
        return maxSumRec(arr, 0, k);
    }
    
    private int maxSumRec(int[] arr, int i, int k) {
        
        // base
        if (i == arr.length) {
            return 0;
        }
        
        if (dp[i] == -1) {
            
            int ans = 0;
            int max = 0;
            
            for(int len = 1; len <= k && i+len-1 < arr.length; len++) {

                max = Math.max(max, arr[i+len-1]);

                int ans2 = max * len + maxSumRec(arr, i+len, k);        

                ans = Math.max(ans, ans2);
            }
            
            dp[i] = ans;
        }

        return dp[i];
    }
}