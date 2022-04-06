class Solution {
    public int hIndex(int[] citations) {
        
        // Arrays.sort(citations);
        
        int n = citations.length;

        int[] counts = new int[n+1];
        
        for (int c : citations) {
            if (c >= n) {
                counts[n]++;
            }
            else {
                counts[c]++;
            }
        }
        
        for (int i = n-1; i >= 0; i--) {
            counts[i] += counts[i+1];
        }
        
        int h = n;
        
        while (h > 0) {
            
            if(counts[h] >= h) {
                return h;
            }
            
            h--;
        }
        
        return 0;
    }
} 