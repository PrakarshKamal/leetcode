class Solution {
    
    private int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<Double, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            double strKey = getHashCode(s);
            
            if (!map.containsKey(strKey)) {
                map.put(strKey, new ArrayList<>());
            }
            map.get(strKey).add(s);
        }
        return new ArrayList<>(map.values());
    }
    
    private double getHashCode(String str) {
        double strKey = 1;
        
        for (int i = 0; i < str.length(); i++) {
            
            char ch = str.charAt(i);
            
            strKey = strKey * primes[ch - 'a'];
        }
        return strKey;
    }
}