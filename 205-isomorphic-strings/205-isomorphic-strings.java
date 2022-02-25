class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> stMap = new HashMap<>();
        Map<Character, Character> tsMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            
            char s_t = s.charAt(i);
            char t_s = t.charAt(i);

            if (stMap.containsKey(s_t)) {
               char mapped = stMap.get(s_t);
               if (mapped != t_s) {
                   return false;
               }
           }
            else {
                   stMap.put(s_t, t_s);
               }
            
            if (tsMap.containsKey(t_s)) {
               char mapped = tsMap.get(t_s);
               if (mapped != s_t) {
                   return false;
               }
           }
            else {
                   tsMap.put(t_s, s_t);
               }
        }
        return true;
    }           
}