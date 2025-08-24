class Solution {
    // Staircase method O(m+n) time, O(1) space
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            int val = matrix[row][col];

            if (target > val) {
                row++;
            }
            else if (target < val) {
                col--;
            }
            else {
                return true;
            }
        }
        return false;
    }
}