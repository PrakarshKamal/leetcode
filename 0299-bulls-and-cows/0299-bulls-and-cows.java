class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int bullCount = 0;
        int cowCount = 0;

        for (int i = 0; i < n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bullCount++;
            }
            else {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            int freq = map.getOrDefault(g, 0);
            if (s != g && freq > 0) {
                cowCount++;
                map.put(g, freq-1);
            }
        }
        sb.append(bullCount).append('A').append(cowCount).append('B');
        return sb.toString();
    }
}