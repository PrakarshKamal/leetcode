class Solution {
    // String O(n) time, O(1) space
    public int longestBeautifulSubstring(String word) {
        int maxLen = 0;
        int currLen = 1;
        int vowelCount = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                currLen++;
            }
            else if (word.charAt(i - 1) < word.charAt(i)) {
                currLen++;
                vowelCount++;
            }
            else {
                currLen = 1;
                vowelCount = 1;
            }

            if (vowelCount == 5) {
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }
}