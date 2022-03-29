// TC : O(n)
// SC : O(1)

class Solution {
    public int calculate(String s) {
        
        int curr = 0;
        int tail = 0;
        int res = 0;
        
        char lastOperator = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }
            
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) { // c is operator
                
                if (lastOperator == '+') {
                    res += curr;
                    tail = curr;
                }    

                else if (lastOperator == '-') {
                    res -= curr;
                    tail = - curr;
                }

                else if (lastOperator == '*') {
                    res = res - tail + tail * curr;
                    tail = tail * curr;
                }

                else if (lastOperator == '/') {
                    res = res - tail + tail / curr;
                    tail = tail / curr;
                }
            
                curr = 0;
                lastOperator = c;
            }
        }
        return res;
    }
}