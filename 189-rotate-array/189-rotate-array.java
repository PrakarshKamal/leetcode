class Solution {
    
    //TC: O(2n)
    //SC: O(1)
    
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        k = k % n;
        
        // 0 1 2 3 4 5
        reverse(nums, 0, n-1);
        // 5 4 3 2 1 0
        
        // reversing first 3 elements when k = 3
        reverse(nums, 0, k - 1);
        
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            start++;
            end--;
        }
    }
    
//     // TC: O(n)
//     // SC: O(k)
//     public void rotate(int[] nums, int k) {
        
//         Queue<Integer> q = new LinkedList<>();
        
//         k = k % nums.length;
        
//         for (int i = nums.length - k; i < nums.length; i++) {
//             q.add(nums[i]);
//         }
        
//         for (int j = 0; j < nums.length; j++) { 
//             q.add(nums[j]);
//             nums[j] = q.remove();
//         }
//     }
    
}