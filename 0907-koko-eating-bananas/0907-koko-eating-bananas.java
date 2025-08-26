class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }

        while (low <= high) {
            int k = low + (high - low) / 2;

            // long hours = 0;
            int hours = 0;
            for (int p : piles) {
                // hours += (p + k - 1) / k;
                hours += Math.ceil((double) p / k);
            }

            if (hours <= h) {
                high = k - 1;
            }
            else {
                low = k + 1;
            }
        }
        return low;
    }
}