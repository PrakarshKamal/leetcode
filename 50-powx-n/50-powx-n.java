class Solution {
    public double myPow(double x, int n) {
        
        if (n < 0) {
            x = 1/x;
        }
        return myPowRecursive(x, n);
    }
    
    private double myPowRecursive(double x, int n) {
        
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