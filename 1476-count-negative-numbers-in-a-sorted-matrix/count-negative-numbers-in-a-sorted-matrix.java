class Solution {
    public int countNegatives(int[][] grid) {
        int neg = 0;
        int n = grid.length; // row size
        int m = grid[0].length; // col size

        int row = 0;
        int col = 0;
        while(row<n && col <m)
        {
            if(grid[row][col]<0)
            {
                neg += (m-col);
                row++;
                col = 0;
            }
            else col++;
            if(col == m)
            {
                col =0;
                row++;
            }
        }
        return neg;
    }
}