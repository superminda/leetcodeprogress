// Last updated: 10/22/2025, 12:40:23 AM
class Solution {
    private int[] xMoves = {-1, 0, 1, 0};
    private int[] yMoves = {0, 1, 0, -1};
    public int findMaxFish(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                queue.offer(new int[]{i, j});
                visited[i][j] = true;
                int subResult = 0;
                while (!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    subResult += grid[pos[0]][pos[1]];
                    for (int idx = 0; idx < xMoves.length; idx++) {
                        int x = xMoves[idx] + pos[0];
                        int y = yMoves[idx] + pos[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > 0 && !visited[x][y]) {
                            visited[x][y] = true;
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
                result = Math.max(result, subResult);
            }
        }
        return result;
    }
}