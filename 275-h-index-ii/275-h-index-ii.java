//TC: O(log n)
//SC: O(1)

class Solution {
    
    public int hIndex(int[] citations) {
        
        int n = citations.length;
        int start = 0;
        int end = n - 1;
        
        while (start <= end) {
            
            int mid = start + (end - start) / 2;
            
            int h = n - mid;
            
            if(citations[mid] == h) {
                return h;
            }
            
            else if (citations[mid] < h) {
                start = mid + 1;
            }
            
            else {
                end = mid - 1;
            }
        }
        
        return n - start;
    }
}