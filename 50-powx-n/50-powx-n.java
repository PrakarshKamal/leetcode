class Solution {
    public double myPow(double x, int n) {
        long N = n;
        
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        return myPowRecursive(x, N);
    }
    
    private double myPowRecursive(double x, long n) {
        
        // base
        if (n == 0) {
            return 1;
        }
        
        // rec
        double res = myPowRecursive(x, n/2);
        
        if (n % 2 == 0) {
            return res * res;
        }
        return res * res * x;
    }
}