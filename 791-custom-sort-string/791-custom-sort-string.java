class Solution {
    public String customSortString(String order, String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            char x = s.charAt(i);
            
            map.put(x, map.getOrDefault(x, 0)+1); // following 1-indexing and considering chars not in order as 0
        }
        
        StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i < order.length(); i++) {
            
            char c = order.charAt(i);
            
            int frequency = map.getOrDefault(c, 0);
            
            while (frequency > 0) {
                ans.append(c);
                frequency--;
            }
            
            map.remove(c);
        }
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char remaining = entry.getKey();
            int frequency = entry.getValue();
            
            while (frequency > 0) {
                ans.append(remaining);
                frequency--;
            }
        }
        
        return ans.toString();
    }
}