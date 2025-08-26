class Solution {
    // Binary search range O(n log m) time, O(1) space
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int p : piles) {
            high = Math.max(high, p);
        }

        while (low <= high) {
            int k = low + (high - low) / 2;

            long hours = 0;
            
            if (canFinish(piles, h, k)) {
                high = k - 1;
            }
            else {
                low = k + 1;
            }
        }
        return low;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + k - 1) / k; // same as hours += Math.ceil((double) p / k)
        }
        return hours <= h;
    }
}