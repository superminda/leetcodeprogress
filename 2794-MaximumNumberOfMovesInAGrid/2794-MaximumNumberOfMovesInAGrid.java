// Last updated: 10/22/2025, 12:40:15 AM
class Solution {
    public int maxMoves(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (i - 1 >= 0 && grid[i][j] > grid[i - 1][j - 1] && (j == 1 || dp[i - 1][j - 1] != 0)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                if (grid[i][j] > grid[i][j - 1] && (j == 1 || dp[i][j - 1] != 0)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                }
                if (i + 1 < m && grid[i][j] > grid[i + 1][j - 1] && (j == 1 || dp[i + 1][j - 1] != 0)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}