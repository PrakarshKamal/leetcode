class Solution {
    // Using Stack O(n) time, O(n) space
    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s) {
            stack.push(c);
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
        
    }
}