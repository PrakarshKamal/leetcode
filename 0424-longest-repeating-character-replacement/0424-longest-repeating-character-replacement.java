class Solution {
    // Sliding Window O(n) time, O(1) space since only 26 letters
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxFreq = 0, length = 0;

        if (s.length() == 1) return 1;
        if (s.length() == k) return k; // can replace entire string

        // Expand window with right pointer
        for (int right = 0; right < s.length(); right++) {
            char cR = s.charAt(right);
            // add frequency of char to map
            map.put(cR, map.getOrDefault(cR, 0) + 1); 

            // Track the max frequency we've seen in this window
            maxFreq = Math.max(maxFreq, map.get(cR));

            // If window is invalid (needs more than k replacements), shrink it
            while ((right - left + 1) - maxFreq > k) {
                char cL = s.charAt(left);
                // dropping one occurrence of cL from window and left forward
                map.put(cL, map.get(cL) - 1); 
                left++;
            }
            length = Math.max(right - left + 1, length);
        }
        return length;
    }
}