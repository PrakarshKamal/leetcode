//TC: O(n)
//SC: O(1)

class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        
        for (int i = n - 2; i >= 0; i--) {
            
            if (nums[i] < nums[i+1]) {
                
                int j = n - 1;
                
                while (j > i) {
                    
                    if (nums[j] > nums[i]) {
                        break;
                    }
                    
                    j--;
                }
                
                swap(nums, i, j);
                
                reverse(nums, i + 1, n - 1);
                
                return;
            }
        }
        
        reverse(nums, 0, n - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}