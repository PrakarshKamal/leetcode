class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        
        int l = 0;
        int r = arr.length - k;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            int d1 = Math.abs(x-arr[mid]);
            int d2 = Math.abs(x-arr[mid+k]);
            
            if (arr[mid] == arr[mid+k]) {
                
                if (arr[mid] < x) {
                    l = mid + 1;
                }
                else {
                    r = mid;
                }
            }
            
            else if (d2 < d1) {
                l = mid + 1;
            }
            
            else {
                r = mid;
            }
        }

        for(int i = l; i < l+k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}