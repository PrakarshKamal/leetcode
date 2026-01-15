// O(n) time, O(n) space
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int space = s.lastIndexOf(' ');
        String word = s.substring(space+1, s.length());

        return word.length();
    }
}