// Last updated: 10/22/2025, 12:41:03 AM
class Solution {
    public int maxSum(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                result = Math.max(result, getHourglass(i, j, grid));
            }
        }
        return result;
    }
    
    private int getHourglass(int i, int j, int[][] grid) {
        return grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
    }
}