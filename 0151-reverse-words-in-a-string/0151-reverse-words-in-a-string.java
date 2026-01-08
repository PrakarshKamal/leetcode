class Solution {
    public String reverseWords(String s) {
        String[] parts = s.split("\\s+");
        int left = 0;
        int right = parts.length-1;

        while (left < right) {
            String temp = parts[left];
            parts[left] = parts[right];
            parts[right] = temp;
            left++;
            right--;
        }
        String ans = String.join(" ", parts).trim();
        return ans;
    }
}