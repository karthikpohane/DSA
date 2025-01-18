import java.util.PriorityQueue;

class Solution {
    private static final int[][] DIRECTIONS = {
        {0, 1},  // Right
        {0, -1}, // Left
        {1, 0},  // Down
        {-1, 0}  // Up
    };

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] cost = new int[m][n];

        // Initialize cost array with a high value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // Add the starting cell to the priority queue
        pq.offer(new int[]{0, 0, 0}); // {row, col, cost}
        cost[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int currentCost = current[2];

            if (row == m - 1 && col == n - 1) {
                return currentCost;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + DIRECTIONS[i][0];
                int newCol = col + DIRECTIONS[i][1];
                int newCost = currentCost + (grid[row][col] == i + 1 ? 0 : 1);

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && newCost < cost[newRow][newCol]) {
                    cost[newRow][newCol] = newCost;
                    pq.offer(new int[]{newRow, newCol, newCost});
                }
            }
        }

        return -1; // Should not reach here as there must be at least one valid path.
    }
}
