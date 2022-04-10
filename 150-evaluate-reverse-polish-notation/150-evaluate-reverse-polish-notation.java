class Solution {
    public int evalRPN(String[] tokens) {
        
        //["2","1","+","3","*"]
        
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