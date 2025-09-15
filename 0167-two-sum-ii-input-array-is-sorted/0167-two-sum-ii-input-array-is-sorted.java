class Solution {
    // Two Pointers O(n) time, O(1) space
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (target < sum) {
                right--;
            }
            else if (target > sum) {
                left++;
            }
            else {
                return new int[] {left + 1, right + 1};
            }
        }
        return new int[] {-1, -1};
    }
}