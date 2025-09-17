class Solution {
    // Two Pointers O(n) time, O(1) space
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            // Area is height * width
            // height is limited by the smaller vertical line so we take minimum
            // width is simply (right - left)
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);

            // to maximize width, we left height if its smaller than right height
            // since we could get new taller height[left]
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return max;
    }
}