class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int currArea = 0;
        int maxArea = 0;
        int left = 0;
        int right = n-1;

        while (left <= right) {
            currArea = (right-left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currArea);
            
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    }
}