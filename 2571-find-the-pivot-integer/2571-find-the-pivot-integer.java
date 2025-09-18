class Solution {
    public int pivotInteger(int n) {
        // total sum 1 to n = n(n+1) / 2
        int total = n * (n + 1) / 2;

        int root = (int) Math.sqrt(total);

        if (root * root == total) {
            return root;
        }
        return -1;
    }
}