class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int n = arr.length;
        
        // edge case
        if (n == 0) {
            return arr;
        }
        
        
        int[] temp = Arrays.copyOf(arr, n);
        
        Arrays.sort(temp);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        // initial rank
        int rank = 1;
        
        for (int ele = 0; ele < n; ele++) {
            if (!map.containsKey(temp[ele])) {
                map.put(temp[ele], rank);
                rank++;
            }
        }
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            result[i] = map.get(arr[i]);
        }
        return result;
    }
}