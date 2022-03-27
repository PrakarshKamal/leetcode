class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ans = new ArrayList<>();
        
        int[] pFreq = new int[26];
        int[] sWindowFreq = new int[26];
        
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            
        }
        
        int endOfWindow = 0;
        
        while (endOfWindow < s.length()) {
            
            //incoming
            sWindowFreq[s.charAt(endOfWindow) - 'a']++;
            
            //outgoing
            if (endOfWindow >= p.length()) {
                sWindowFreq[s.charAt(endOfWindow - p.length()) - 'a']--;
                
            }
            
            if (Arrays.equals(pFreq, sWindowFreq)) {
                ans.add(endOfWindow - p.length() + 1);
            }
            
            endOfWindow++;
        }
        return ans;
    }
}