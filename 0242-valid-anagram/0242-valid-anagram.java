class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] ans = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            ans[sChar - 'a']++;
            ans[tChar - 'a']--;
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != 0) {
                return false;
            }
        }
        return true;
    }
}