// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> stack = new Stack<>();
//         if(s.length() == 1) {
//             return false;
//         }
//         for(char c : s.toCharArray()) {
//             if(c == '(' || c == '[' || c == '{') {
//                 stack.push(c);
//             }
//             else {
//                 if(stack.isEmpty()) {
//                     return false;
//                 }
//                 char top = stack.pop();
//                 if (c == ')' && top != '(' ||
//                     c == ']' && top != '[' ||
//                     c == '}' && top != '{') {
//                     return false;
//                 }
//             }
//         }
//         return stack.isEmpty();
//     }
// }
class Solution {
    
    
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
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
