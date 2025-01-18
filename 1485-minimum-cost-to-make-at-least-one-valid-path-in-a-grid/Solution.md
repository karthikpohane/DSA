# Understanding the Code: Minimum Cost Path Using Dijkstra's Algorithm

## Problem Overview
You are given a grid where each cell has a direction that points to the next cell. The goal is to start at the top-left corner of the grid and reach the bottom-right corner with the minimum cost. You can change the direction of any cell, but each change costs 1.

### Directions Mapping:
- **1**: Move Right
- **2**: Move Left
- **3**: Move Down
- **4**: Move Up

The objective is to compute the minimum cost to make at least one valid path from the top-left to the bottom-right cell.

---

## Key Concepts Explained

### 1. **Dijkstra's Algorithm**
Dijkstra's algorithm is a graph-based algorithm to find the shortest path from a starting node to all other nodes. In this case, the grid can be thought of as a graph where each cell is a node, and the cost to move between nodes depends on whether the current direction matches the desired direction.

#### Steps in Dijkstra's Algorithm:
1. **Initialization**:
   - Start from the initial node (top-left corner).
   - Set the cost to reach the starting node to `0` and all other nodes to `∞` (infinity).
2. **Priority Queue**:
   - Use a priority queue to always expand the least-cost node first.
3. **Relaxation**:
   - For each neighboring node, calculate the cost to reach it.
   - Update the cost if the new path is cheaper.
4. **Termination**:
   - Stop when the target node (bottom-right corner) is processed.

### 2. **Priority Queue**
A priority queue is a data structure where elements are processed based on their priority (lowest cost first, in this case). In Java, this is implemented using the `PriorityQueue` class. The priority queue is used to keep track of cells to explore, sorted by their cost.

#### Example:
```java
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
```
Here, the priority queue stores arrays `{row, col, cost}` and sorts them by `cost` in ascending order.

---

## Code Walkthrough

### **Global Directions Array**
```java
private static final int[][] DIRECTIONS = {
    {0, 1},  // Right
    {0, -1}, // Left
    {1, 0},  // Down
    {-1, 0}  // Up
};
```
This array maps the four possible movement directions: right, left, down, and up.

### **Initialization**
1. **Grid Dimensions:**
   ```java
   int m = grid.length, n = grid[0].length;
   ```
   `m` and `n` store the number of rows and columns in the grid.

2. **Cost Array:**
   ```java
   int[][] cost = new int[m][n];
   for (int i = 0; i < m; i++) {
       for (int j = 0; j < n; j++) {
           cost[i][j] = Integer.MAX_VALUE;
       }
   }
   ```
   This array tracks the minimum cost to reach each cell, initialized to a high value (`Integer.MAX_VALUE`).

3. **Priority Queue:**
   ```java
   PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
   pq.offer(new int[]{0, 0, 0}); // Start from the top-left corner with cost 0
   cost[0][0] = 0;
   ```
   The priority queue stores `{row, col, cost}` and starts with the top-left corner.

### **Main Loop**
```java
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
```
#### Explanation:
1. **Processing Cells:**
   - Remove the cell with the smallest cost from the priority queue.
   - Check if it is the bottom-right cell. If yes, return the cost.

2. **Exploring Neighbors:**
   - For each of the four possible directions, calculate the new position and cost.
   - If moving in the grid’s suggested direction, the cost remains the same; otherwise, add 1.

3. **Cost Update:**
   - If the new cost is smaller than the previously recorded cost for the cell, update it and add the cell to the queue.

### **Termination Condition**
If the bottom-right cell is reached, return its cost. If the queue is empty without reaching it, return `-1` (although the problem guarantees at least one valid path).

---

## Examples

### Example 1:
#### Input:
```java
int[][] grid = {{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}};
```
#### Output:
```java
3
```
#### Explanation:
The optimal path involves changing the direction at three specific cells.

### Example 2:
#### Input:
```java
int[][] grid = {{1, 1, 3}, {3, 2, 2}, {1, 1, 4}};
```
#### Output:
```java
0
```
#### Explanation:
The grid’s initial configuration already provides a valid path without changes.

### Example 3:
#### Input:
```java
int[][] grid = {{1, 2}, {4, 3}};
```
#### Output:
```java
1
```
#### Explanation:
One change is needed to create a valid path.

---

## Key Learnings
1. **Grid Representation:**
   - Think of the grid as a graph where each cell is a node.

2. **Dijkstra’s Algorithm in Grids:**
   - Use a priority queue to efficiently explore cells with the smallest cost first.

3. **Cost Calculation:**
   - Adapt the cost calculation based on the problem’s requirements, like matching directions.

4. **Edge Cases:**
   - Ensure bounds checking (`newRow` and `newCol` within grid limits).
   - Handle grids with varying sizes and directions.

---

This approach ensures optimal performance with \(O(m \times n \log(m \times n))\) complexity, where \(m\) and \(n\) are the grid dimensions.

