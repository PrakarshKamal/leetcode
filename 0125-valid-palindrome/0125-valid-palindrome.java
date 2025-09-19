class Solution {
    // Two Pointers, O(n) time, O(1) space
    // public boolean isPalindrome(String s) {
    //     // s = s.toLowerCase().replaceAll("[^a-z0-9]", ""); // regex trick
    //     int left = 0;
    //     int right = s.length() - 1;

    //     if (s.length() == 1) return true;

    //     while (left < right) {
    //         while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
    //             left++;
    //         }
    //         while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
    //             right--;
    //         }

    //         char cL = Character.toLowerCase(s.charAt(left));
    //         char cR = Character.toLowerCase(s.charAt(right));

    //         if (cL != cR) return false;

    //         left++;
    //         right--;
    //     }
    //     return true;
    // }

    // Recursive approach O(n) time, O(n) space
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        if (s.length() == 1) return true;
        return isPalindromeHelper(s, left, right);
    }

    private boolean isPalindromeHelper(String s, int left, int right) {
        // base case, pointers crossed so nothing to check
        if (left >= right) return true; 

        if (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            return isPalindromeHelper(s, left + 1, right);
        }
        if (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            return isPalindromeHelper(s, left, right - 1);
        }
        
        char cL = Character.toLowerCase(s.charAt(left));
        char cR = Character.toLowerCase(s.charAt(right));

        if (cL != cR) {
            return false;
        }
        return isPalindromeHelper(s, left + 1, right - 1);
    }
}