// O(n) time, O(n) space
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String s = tokens[i];
            if (s.equals("+")) {
                int a = st.pop();
                int b = st.pop();
                st.push(a+b);
            }
            else if (s.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b-a);
            }
            else if (s.equals("*")) {
                int a = st.pop();
                int b = st.pop();
                st.push(a*b);
            }
            else if (s.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            }
            else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}