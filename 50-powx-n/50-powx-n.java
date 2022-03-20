class Solution {
    public double myPow(double x, int n) {

        long N = n;
        double xp = x;
        double ans = 1;
        
        if (N < 0) {
            xp = 1/x;
            N = -N;
        }
        
        while (N > 0) {
            if (N % 2 != 0) {
                ans = ans * xp;
            }
            xp = xp * xp;
            N = N / 2;
        }
        return ans;
    }
}