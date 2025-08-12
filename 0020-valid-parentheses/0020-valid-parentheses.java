class Solution {
    public boolean isValid(String s) {
        // Stack<Character> stack = new Stack<>();
        // // if(s.length() == 1) {
        // //     return false;
        // // }
        // for(char c : s.toCharArray()) {
        //     if(c == '(' || c == '[' || c == '{') {
        //         stack.push(c);
        //     }
        //     else {
        //         if(stack.isEmpty()) {
        //             return false;
        //         }
        //         char top = stack.pop();
        //         if (c == ')' && top != '(' ||
        //             c == ']' && top != '[' ||
        //             c == '}' && top != '{') {
        //             return false;
        //         }
        //     }
        // }
        // return stack.isEmpty();
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            }
            else if (stack.empty() || stack.pop() != c) return false;
        }
        return stack.empty();
    }
}