class Solution {
    
    private List<String> result;
    private String nums;
    private int target;
    
    
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        this.nums = num;
        this.target = target;
        
        evaluate(0, 0, 0, new ArrayList<>());
        
        return result;
    }
    
    private void evaluate(int index, long value, long tail, List<String> operators) {
        
        // base case
        if (index == nums.length()) {

            if (value == target) {

                StringBuilder ans = new StringBuilder();
                for (String op : operators) {
                    ans.append(op);
                }
                result.add(ans.toString());
            }
            return;
        }
                    
        // recursive
        for (int i = index; i < nums.length(); i++) {

            String operandString = nums.substring(index, i+1);
            
            if (operandString.length() == 2 && operandString.charAt(0) == '0') {
                break;
            }
            
            long operand = Long.parseLong(operandString);
            
            if (index == 0) {
                
                operators.add(operandString);
                evaluate(i+1, operand, operand, operators);
                
                operators.remove(operators.size()-1);
            }
            
            else {
                
                // add
                operators.add("+" + operandString);
                evaluate(
                    i+1,
                    value + operand, // value
                    operand, // tail
                    operators
                );
                operators.remove(operators.size()-1);
                
                // sub
                operators.add("-" + operandString);
                evaluate(
                    i+1,
                    value - operand, // value
                    - operand, // tail
                    operators
                );
                operators.remove(operators.size()-1);
                
                // mult
                operators.add("*" + operandString);
                evaluate(
                    i+1,
                    value - tail + tail * operand, // value
                    tail * operand, // tail
                    operators
                );
                operators.remove(operators.size()-1);
            }
        }
    }
}