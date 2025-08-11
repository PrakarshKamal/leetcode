class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) {
            return false;
        }

        // Solution1 Sorting: O(nlogn + mlogm) time, O(1) space
        // char[] s1 = s.toCharArray();
        // Arrays.sort(s1);
        // String sortedS = new String(s1);

        // char[] t1 = t.toCharArray();
        // Arrays.sort(t1);
        // String sortedT = new String(t1);

        // if(sortedS.equals(sortedT)) {
        //     return true;
        // }
        // return false;


        // Solution2 Hashing: O(n + m) time, O(1) space
        // HashMap<Character, Integer> sMap = new HashMap<>();
        // HashMap<Character, Integer> tMap = new HashMap<>();

        // for(int i = 0; i < s.length(); i++) {
        //     char sChar = s.charAt(i);
        //     char tChar = t.charAt(i);
        //     sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
        //     tMap.put(tChar, tMap.getOrDefault(tChar, 0) + 1);
        // }
        // return sMap.equals(tMap);

        // Solution3 Char trick: O(n + m) time, O(1) space
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            arr[sChar - 'a']++;
            arr[tChar - 'a']--;
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}