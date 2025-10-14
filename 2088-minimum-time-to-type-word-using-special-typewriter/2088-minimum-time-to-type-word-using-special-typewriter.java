class Solution {
    // String Greedy O(n) time, O(1) space
    public int minTimeToType(String word) {
        int total = 0;
        char prev = 'a';

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            int diff = Math.abs(curr - prev);
            int minimum = Math.min(diff, 26 - diff);
            total += minimum + 1;
            prev = curr;
        }
        return total;
    }
}