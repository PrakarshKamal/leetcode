class Solution {
    // Using Stack O(n) time, O(n) space
    // public void reverseString(char[] s) {
    //     Stack<Character> stack = new Stack<>();
    //     for (char c : s) {
    //         stack.push(c);
    //     }
    //     for (int i = 0; i < s.length; i++) {
    //         s[i] = stack.pop();
    //     }  
    // }
    public void reverseString(char[] s) {
        // Two Pointers O(n) time, O(1) space
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}