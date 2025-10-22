// Last updated: 10/22/2025, 12:39:11 AM
class Solution {
    public int minimumOperations(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int j = 0; j < n; j++) {
            int prevMax = grid[0][j];
            for (int i = 1; i < m; i++) {
                if (prevMax < grid[i][j]) {
                    prevMax = grid[i][j];
                } else {
                    int targetNum = prevMax + 1;
                    result += (targetNum - grid[i][j]);
                    prevMax = targetNum;
                }
            }
        }
        return result;
    }
}