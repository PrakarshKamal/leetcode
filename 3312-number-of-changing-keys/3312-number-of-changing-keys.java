class Solution {
    // O(n) time, O(1) space

    public int countKeyChanges(String s) {
        s = s.toLowerCase();
        if (s.length() == 1) return 0;
        int count = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                count++;
            }
        }
        return count;
    }

    // public int countKeyChanges(String s) {
    //     if (s.length() == 1) {
    //         return 0;
    //     }
    //     int count = 0;
    //     char lastUsed = Character.toLowerCase(s.charAt(0));
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = Character.toLowerCase(s.charAt(i));
    //         System.out.println(c);
    //         if (c == lastUsed) {
    //             continue;
    //         }
    //         count++;
    //         lastUsed = c;
    //     }
    //     return count;
    // }
}