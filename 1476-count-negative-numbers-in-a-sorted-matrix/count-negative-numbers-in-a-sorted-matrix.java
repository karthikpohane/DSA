class Solution {
    public int countNegatives(int[][] grid) {
        int neg = 0; 
        int n = grid.length; 
        int m = grid[0].length; 

        int row = 0; 
        int col = m - 1; 

       
        while (row < n && col >= 0) {
            if (grid[row][col] < 0) {
                neg += (n - row);
                col--; 
            } else {
                row++;
            }
        }
        return neg;
    }
}
