class Solution {
    // Sliding Window O(n) time, O(m) space, m is no. of chars in s
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int length = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right); // keep expanding window to right
            // shrink window until no duplicate of right char
            while (set.contains(c)) { 
                set.remove(s.charAt(left)); // remove char at left
                left++;
            }
            set.add(c); // add curr right char to set
            // get max length by comparing with current window size
            length = Math.max(right - left + 1, length);
        }
        return length;
    }
}