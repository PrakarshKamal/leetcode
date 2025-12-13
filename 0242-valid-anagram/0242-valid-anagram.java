class Solution {
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) return false;

    //     int[] ans = new int[26];

    //     for (int i = 0; i < s.length(); i++) {
    //         char sChar = s.charAt(i);
    //         char tChar = t.charAt(i);
    //         ans[sChar - 'a']++;
    //         ans[tChar - 'a']--;
    //     }

    //     for (int i = 0; i < ans.length; i++) {
    //         if (ans[i] != 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            sMap.put(sChar, sMap.getOrDefault(sChar, 0)+1);
            tMap.put(tChar, tMap.getOrDefault(tChar, 0)+1);
        }

        if (sMap.equals(tMap)) {
            return true;
        }
        return false;
    }
}