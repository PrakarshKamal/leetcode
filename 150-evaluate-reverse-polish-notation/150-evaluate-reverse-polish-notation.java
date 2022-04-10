//TC: O(n) for looping through tokens
//SCL O(n) for maintaining stack

class Solution {
    public int evalRPN(String[] tokens) {
        
        //approach is to keep pushing integers until we see an operator (+, -, *, /)
        //when operator is seen, pop twice from stack and evaluate
        //in evaluation, we place second operand before first (b+a, b-a, b*a, b/a) to maintain the order
        //then push the result of evaluation to stack
        //finally return top of stack
        
        Stack<Integer> stack = new Stack<>();
        
        for (String s : tokens) {
            
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                
                int val1 = stack.pop();
                int val2 = stack.pop();
                
                if (s.equals("+")) {
                    stack.push(val2 + val1);
                }
                
                if (s.equals("-")) {
                    stack.push(val2 - val1);
                }
                
                if (s.equals("*")) {
                    stack.push(val2 * val1);
                }
                
                if (s.equals("/")) {
                    stack.push(val2 / val1);
                }
            }
            
            else {
                stack.push(Integer.valueOf(s));
            }
        }
        
        return stack.peek();
    }
}