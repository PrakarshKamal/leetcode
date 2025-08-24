class Solution {
    // Brute forice O(m * n) time, O(1) space
    public boolean searchMatrix(int[][] matrix, int target) {
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[i].length; j++) {
        //         if (matrix[i][j] == target) {
        //             return true;
        //         }
        //     }
        // }
        // return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;

        while (top <= bottom) {
            int row = (top + bottom) / 2;

            if (target > matrix[row][cols - 1]) {
                top = row + 1;
            }
            else if (target < matrix[row][0]) {
                bottom = row - 1;
            }
            else {
                break;
            }
        }

        if (!(top <= bottom)) {
            return false;
        }

        int currRow = (top + bottom) / 2;
        int left = 0;
        int right = cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (target > matrix[currRow][mid]) {
                left = mid + 1;
            }
            else if (target < matrix[currRow][mid]) {
                right = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }


}