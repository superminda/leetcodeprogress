// Last updated: 10/22/2025, 12:40:37 AM
class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];
        for (int j = 0; j < n; j++) {
            int maxLength = 0;
            for (int i = 0; i < m; i++) {
                maxLength = Math.max(maxLength, String.valueOf(grid[i][j]).length());
            }
            result[j] = maxLength;
        }
        
        return result;
    }
}