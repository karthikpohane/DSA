class Solution {
    public long gridGame(int[][] grid) {
        long firstRowRemaininSum = 0;
        for(long numSum : grid[0])
            firstRowRemaininSum += numSum;
        long secondRowRemainSum = 0;
        long minimizedRonbot2Sum = Long.MAX_VALUE;
        for(int RobotCol = 0; RobotCol<grid[0].length; RobotCol++)
        {
            firstRowRemaininSum -= grid[0][RobotCol];
            long bestOfrobot2 = Math.max(firstRowRemaininSum, secondRowRemainSum);
            minimizedRonbot2Sum = Math.min(minimizedRonbot2Sum, bestOfrobot2);
            secondRowRemainSum += grid[1][RobotCol];
        }
        return minimizedRonbot2Sum;
    }
}