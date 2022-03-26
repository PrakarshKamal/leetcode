class Solution {
    
    // sliding window approach
    
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        
        int max = 0;
        int start = 0;
        int end = 0;
        
        while (end < s.length()) {
            
            char c = s.charAt(end);
            
            if (set.contains(c)) {
                set.remove(s.charAt(start));
                start++;
            }
            
            else {
                set.add(c);
                end++;
                max = Math.max(max, (end-start));
            }
        }
        
        return max;
    }
}