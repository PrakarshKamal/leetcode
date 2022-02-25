class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] arr = s.split("\s+");

        if (pattern.length() != arr.length) {
            return false;
        }

        Map<String, Character> patternMap = new HashMap<>();
        Map<Character, String> stringMap = new HashMap<>();
        
        for (int i=0; i<arr.length; i++) {
            char pattChar = pattern.charAt(i);
            String ele = arr[i];
            
            // System.out.println(pattChar + "=" + ele);
            
            if (patternMap.containsKey(ele)) {
                char mapped = patternMap.get(ele);
                    
                // System.out.println(mapped + "=" + pattChar);
                    
                if (mapped != pattChar) {
                    return false;
                }
            }
            else {
                patternMap.put(ele, pattChar);
            }
            
            if (stringMap.containsKey(pattChar)) {
                String mapped = stringMap.get(pattChar);

                if (!mapped.equals(ele)) {
                    return false;
                }
            }
            else {
                stringMap.put(pattChar, ele);
            }
        }
        return true;
    }
}
