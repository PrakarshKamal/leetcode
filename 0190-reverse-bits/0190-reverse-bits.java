class Solution {
    // O(1) time, O(1) space
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // int lastBit = n & 1;

            ans <<= 1;

            // ans |= lastBit;
            if ((n & 1) == 1) {
                ans++;
            }

            n >>= 1;
        }
        return ans;
    }
}