class Solution {
    public int fib(int n) {
        // Recursion base case
        // if (n <= 1) {
        //     return n;
        // }
        // int fib1 = fib(n - 1);
        // int fib2 = fib(n - 2);

        // return fib1 + fib2;

        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            int ans = a + b;
            a = b;
            b = ans;
        }
        return b;
    }
}