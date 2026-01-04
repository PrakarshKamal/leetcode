class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        StringBuilder sb = new StringBuilder();
        // Map<Character, Integer> map = new HashMap<>();
        int[] arr = new int[10];
        int bullCount = 0;
        int cowCount = 0;
        for (int i = 0; i < n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bullCount++;
            }
            else {
                // map.put(s, map.getOrDefault(s, 0) + 1);
                arr[s - '0']++;
            }
        }
        for (int i = 0; i < n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s != g) {
                // int freq = map.getOrDefault(g, 0);
                if (arr[g - '0'] > 0) {
                    cowCount++;
                    // map.put(g, freq-1);
                    arr[g - '0']--;
                }
            }
        }
        sb.append(bullCount).append('A').append(cowCount).append('B');
        return sb.toString();
    }
}