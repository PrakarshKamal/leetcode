class Solution {
    // Two Pointers, O(n) time, O(1) space
    public boolean isPalindrome(String s) {
        // s = s.toLowerCase().replaceAll("[^a-z0-9]", ""); // regex trick
        int left = 0;
        int right = s.length() - 1;

        if (s.length() == 1) return true;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            char cL = Character.toLowerCase(s.charAt(left));
            char cR = Character.toLowerCase(s.charAt(right));

            if (cL != cR) return false;

            left++;
            right--;
        }
        return true;
    }
}