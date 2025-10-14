class Solution {
    // Two Pointers, O(n) time, O(1) space
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char cL = s.charAt(left);
            char cR = s.charAt(right);

            if (cL != cR) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Recursive approach O(n) time, O(n) space
    // public boolean isPalindrome(String s) {
    //     s = s.toLowerCase().replaceAll("[^a-z0-9]", ""); // regex trick
    //     int left = 0;
    //     int right = s.length() - 1;
        
    //     if (s.length() == 1) return true;
    //     return isPalindromeHelper(s, left, right);
    // }

    // private boolean isPalindromeHelper(String s, int left, int right) {
    //     // Sytem.out.println(s);
    //     // base case, pointers crossed so nothing to check
    //     if (left >= right) {
    //         return true;
    //     }

    //     char cL = s.charAt(left);
    //     char cR = s.charAt(right);

    //     if (cL != cR) {
    //         return false;
    //     }
    //     return isPalindromeHelper(s, left + 1, right - 1);
    // }
}