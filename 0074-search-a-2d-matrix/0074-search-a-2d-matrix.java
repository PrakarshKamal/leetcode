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

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = (m * n) - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int i = mid / n;
            int j = mid % n;

            if (target > matrix[i][j]) {
                left = mid + 1;
            }
            else if (target < matrix[i][j]) {
                right = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}