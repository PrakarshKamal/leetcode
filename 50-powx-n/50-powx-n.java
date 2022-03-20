class Solution {
    public double myPow(double x, int n) {
        
        // base
        if (n == 0) {
            return 1;
        }
        
        // rec
        double res = myPow(x, n/2);
        
        if (n % 2 == 0) {
            return res * res;
        }
        
        if (n < 0) {
            x = 1/x;
        }
        return res * res * x;
    }
}