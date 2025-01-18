class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int j = 0; j < matrix.length; j++) {  
            for (int i = 0; i < matrix[j].length; i++) {  
                if (matrix[j][i] == target) {
                    return true;  
                }
            }
        }
        return false;  
    }
}
