class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length; // row
        int m = matrix[0].length; // col
        int top = 0;
        int left = 0;
        int bottom = n-1;
        int right = m-1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) { // going left to right
                ans.add(matrix[top][i]);
            }
            top++; // bring top wall/row down
            
            for (int i = top; i <= bottom; i++) { // going top to bottom
                ans.add(matrix[i][right]);
            }
            right--; // bring right wall/col in

            if (top <= bottom) {
                for (int i = right; i >= left; i--) { // going right to left
                    ans.add(matrix[bottom][i]);
                }
                bottom--; // bring bottom wall/row up
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) { // going bottom to top
                    ans.add(matrix[i][left]);
                }
                left++; // bring left wall/col in
            }   
        }
        return ans;
    }
}
