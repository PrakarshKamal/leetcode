//TC: O(n log n)
//SC: O(1)

class Solution {
    
    public int hIndex(int[] citations) {
        
        Arrays.sort(citations);
        
        int n = citations.length;
        
        int h = n;
        
        while (h > 0) {
            
            if(citations[n-h] >= h) {
                return h;
            }
            
            h--;
        }
        
        return h;
    }
}