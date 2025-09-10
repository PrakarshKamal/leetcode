class Solution {
    // O(1) time, O(1) space
    public int hammingWeight(int n) {
        int count = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                // example 23 & 1
                //   10111
                // & 00001
                count++;
            }
            n = n >> 1; // same as n / 2
        }
        return count;
    }
}