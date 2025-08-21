class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1 && k == 1) {
            return 0;
        }
        int rowLength = (int) Math.pow(2, n - 1); // since row length is increasing in power of 2
        int mid = rowLength / 2;

        // this means k is same in first half of current and previous nth row
        if (k <= mid) {
            return kthGrammar(n - 1, k);
        }
        else {
            // both work, ^ is bitwise XOR
            // return 1 - kthGrammar(n - 1, k - mid); 
            return 1 ^ kthGrammar(n - 1, k - mid);
        }
    }
}