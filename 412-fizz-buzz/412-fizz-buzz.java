//TC: O(n)
//SC: O(1)

class Solution {
    public List<String> fizzBuzz(int n) {
        
        List<String> result = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            }
            else if (i % 3 == 0) {
                result.add("Fizz");
            }
            else if (i % 5 == 0) {
                result.add("Buzz");
            }
            else {
                String s = Integer.toString(i);
                result.add(s);    
            }      
        }
        return result;
    }
}