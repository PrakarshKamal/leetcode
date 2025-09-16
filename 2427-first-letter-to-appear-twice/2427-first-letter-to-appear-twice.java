class Solution {
    // O(n) time, O(1) space
    // public char repeatedCharacter(String s) {
    //     int[] count = new int[26];
    //     for (char c : s.toCharArray()) {
    //         count[c - 'a']++;
    //         if (count[c - 'a'] == 2) {
    //             return c;
    //         }
    //     }
    //     return 'a';
    // }
    
    // O(n) time, O(1) space
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return c; // already in set so first to appear twice
            }
            set.add(c);
        }
        return 'a';
    }
}