// Last updated: 10/22/2025, 12:40:38 AM
class Solution {
    private int[] xMoves = {1, 2, 2, 1, -1, -2, -2, -1};
    private int[] yMoves = {-2, -1, 1, 2, 2, 1, -1, -2};
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        int[][] steps = new int[n * n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = grid[i][j];
                steps[index][0] = i;
                steps[index][1] = j;
            }
        }
        int xIndex = 0;
        int yIndex = 0;
        for (int index = 1; index < steps.length; index++) {
            int targetXIndex = steps[index][0];
            int targetYIndex = steps[index][1];
            if (canReach(xIndex, yIndex, targetXIndex, targetYIndex)) {
                xIndex = targetXIndex;
                yIndex = targetYIndex;
            } else {
                return false;
            }
        }
        return true;
    }
    
    private boolean canReach(int xIndex, int yIndex, int targetXIndex, int targetYIndex) {
        for (int i = 0; i < xMoves.length; i++) {
            if ((xIndex + xMoves[i] == targetXIndex) && (yIndex + yMoves[i] == targetYIndex)) {
                return true;
            }
        }
        return false;
    }
}