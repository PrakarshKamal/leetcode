//TC: O(log n)
//SC: O(1)

class Solution {
    public int mySqrt(int x) {
        int start = 1;
        int end = x;
        
        if (x == 0) {
            return 0;
        }
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            if (mid <= x / mid && (mid+1) > x / (mid + 1)) {
                return mid;
            }
            else if (mid > x / mid) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }
}