class Solution {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                myStack.push(c);
            } else if (c == ')' && !myStack.isEmpty() && myStack.peek() == '(') {
                myStack.pop();
            } else if (c == '}' && !myStack.isEmpty() && myStack.peek() == '{') {
                myStack.pop();
            } else if (c == ']' && !myStack.isEmpty() && myStack.peek() == '[') {
                myStack.pop();
            } else {
                return false;
            }
        }
        return myStack.isEmpty();
    }
}