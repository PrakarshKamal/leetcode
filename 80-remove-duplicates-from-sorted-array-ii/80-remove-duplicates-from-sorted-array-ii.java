// TC: O(n)
// SC: O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        
        int insert = 0;
       
        for (int num : nums) {
            
            if (insert < 2 || nums[insert-2] != num) {
                nums[insert] = num;
                insert++;
            }    
        }        
        return insert;
    }
}