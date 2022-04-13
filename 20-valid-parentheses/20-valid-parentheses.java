//TC: O(n) for looping through s
//SC: O(n) for stack of size length of given s

class Solution {
    
    Stack<Character> stack;
    
    public boolean isValid(String s) {
        stack = new Stack<>();
        
        // base case checking if string length is odd
        // if odd, not valid
        if (s.length() % 2 != 0) {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            
            else {
                
                // if s = } that means we have just closed bracket
                // so we check stack before peeking
                if (stack.isEmpty()) {
                    return false;    
                }
                
                else if (isValidParentheses(stack.peek(), c) == true) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isValidParentheses(char brackOpen, char brackClose) {
        return  brackOpen == '(' && brackClose == ')'
                                ||
                brackOpen == '{' && brackClose == '}'
                                ||
                brackOpen == '[' && brackClose == ']';
    }
}