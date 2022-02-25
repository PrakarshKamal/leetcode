class Solution {
    public int longestPalindrome(String s) {
        
        Map<Character, Integer> result = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            result.put(ch, result.getOrDefault(ch, 0)+1);            
        }
        int longestPalin = 0;
        
        boolean oddChar = false;
        
        for (int count : result.values()) {
            if (count % 2 == 0) {
                longestPalin += count;
            }
            else {
                oddChar = true;
                longestPalin += (count - 1);
            }
        }
        if (oddChar) {
            longestPalin += 1;
        }
        return longestPalin;
    }
}