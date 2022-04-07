class Solution {
    public void rotate(int[] nums, int k) {
        
        Queue<Integer> q = new LinkedList<>();
        
        k = k % nums.length;
        
        for (int i = nums.length - k; i < nums.length; i++) {
            q.add(nums[i]);
        }
        
        for (int j = 0; j < nums.length; j++) { 
            q.add(nums[j]);
            nums[j] = q.remove();
        }
    }
}